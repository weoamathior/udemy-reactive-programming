package irish.bla.sec06;

import irish.bla.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;


public class Lec03SubscribeOnMultiple {
    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
                    printThreadName("create");
                    for (int i = 0; i < 4; i++) {
                       fluxSink.next(i);
                       Util.sleepSeconds(1);
                    }
                    fluxSink.complete();
                })
                .doOnNext(i -> printThreadName("Next " + i));

        flux
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(v -> printThreadName("subs " + v));

        Util.sleepSeconds(5);
    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\tThread: " + Thread.currentThread().getName());
    }
}