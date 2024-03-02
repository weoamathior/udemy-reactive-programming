package irish.bla.sec06;

import irish.bla.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;


public class Lec05PubSubOn {
    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
                    printThreadName("create");
                    for (int i = 0; i < 4; i++) {
                       fluxSink.next(i);
                    }
                    fluxSink.complete();
                })
                .doOnNext(i -> printThreadName("Next1 " + i));

        flux
                .publishOn(Schedulers.parallel())
                .doOnNext(i -> printThreadName("Next2 " + i))
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(v -> printThreadName("subs " + v));

        Util.sleepSeconds(5);
    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\tThread: " + Thread.currentThread().getName());
    }
}