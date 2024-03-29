package irish.bla.sec04;

import irish.bla.util.DefaultSubscriber;
import irish.bla.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec06OnError {

    public static void main(String[] args) {

        Flux.range(1,10)
                .log()
                .map(i -> 10 / (5 -i))
//                .onErrorReturn(-1)
//                .onErrorResume(err -> fallback())
                // like a dlq - provides the error and the problematic object
                .onErrorContinue((err,obj) -> {

                })
                .subscribe(DefaultSubscriber.newInstance());

    }

    private static Mono<Integer> fallback() {
        return Mono.fromSupplier(() -> Util.faker().random().nextInt(100,200));
    }
}
