package irish.bla.sec04;

import irish.bla.util.DefaultSubscriber;
import reactor.core.publisher.Flux;


public class Lec03DoCallbacks {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    System.out.println("inside create");
                    for (int i = 0; i < 5; i++) {
                        fluxSink.next(i);
                    }
//                    fluxSink.error(new RuntimeException("oh no"));
                    fluxSink.complete();
                    System.out.println("--complete");
                })
                .doOnComplete(() -> {
                    System.out.println("doOnComplete!");
                })
                // doOnTerminate executes in both complete and error scenarios
                .doOnTerminate(() -> System.out.println("doOnTerminate"))
                // Multiple 'doFirst' callbacks - executed in reverse order
                .doFirst(() -> System.out.println("doFirst! 1"))
                .doOnNext(o -> System.out.println("doOnNext " + o))
                .doOnSubscribe(subscription -> {
                    System.out.println("doOnSubscribe " + subscription);
                })
                .doFirst(() -> System.out.println("doFirst! 2"))
                .doOnRequest(value -> {
                    System.out.println("doOnRequest " + value);
                })
                .doOnError(err -> {
                    System.out.println("doOnError " + err.getMessage());
                })
                .doOnCancel(() -> System.out.println("doOnCancel"))
                .doFirst(() -> System.out.println("doFirst! 3"))
                .doFinally(signalType -> {
                    System.out.println("doFinally 1 " + signalType);
                })
                .doOnDiscard(Object.class, o -> System.out.println("doOnDiscard " + o))
                .take(2)
                .doFinally(signalType -> {
                    System.out.println("doFinally 2 " + signalType);
                })
                .subscribe(DefaultSubscriber.newInstance());
    }
}
