package irish.bla.sec06;

import irish.bla.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/*
output:

first1		Thread: Thread-0
first1		Thread: Thread-1
first2		Thread: boundedElastic-1
first2		Thread: boundedElastic-2
create		Thread: blairish-1
Next 1		Thread: blairish-1
subs 1		Thread: blairish-1
create		Thread: blairish-1
Next 1		Thread: blairish-1
subs 1		Thread: blairish-1


 */
public class Lec02SubscribeOnDemoPart3 {
    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
                    printThreadName("create");
                    fluxSink.next(1);
                })
                // the moral: the closest 'subscribeOn' to the publisher takes precedence
                .subscribeOn(Schedulers.newParallel("blairish"))
                .doOnNext(i -> printThreadName("Next " + i));

        Runnable runnable = () ->flux
                .doFirst(() -> printThreadName("first2"))
                .subscribeOn(Schedulers.boundedElastic())
                .doFirst(() -> printThreadName("first1"))
                .subscribe(v -> printThreadName("subs " + v));

        for (int i = 0; i < 2; i++) {
            new Thread(runnable).start();
        }


        Util.sleepSeconds(5);
    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\tThread: " + Thread.currentThread().getName());
    }
}