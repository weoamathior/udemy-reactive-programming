package irish.bla.sec06;

import irish.bla.util.Util;
import reactor.core.publisher.Flux;

public class Lec01ThreadDemo {
    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
                    printThreadName("create");
                    fluxSink.next(1);
                })
                .doOnNext(i -> printThreadName("doOnNext " + i));

        Runnable runnable = () -> flux.subscribe(v -> printThreadName("subscription " + v));

        for (int i = 0; i < 2; i++) {
            new Thread(runnable).start();
        }

        Util.sleepSeconds(5);
    }
    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\tThread: " +Thread.currentThread().getName());
    }
}
