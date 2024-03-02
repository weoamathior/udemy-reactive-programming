package irish.bla.sec06;

import irish.bla.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec06Parallel {
    public static void main(String[] args) {
        Flux.range(1,10)
                .parallel(2)
//                .runOn(Schedulers.boundedElastic())
                .runOn(Schedulers.parallel())
                .doOnNext(i -> printThreadName("next1: " + i))
                .subscribe(v -> printThreadName("sub " + v));

        Util.sleepSeconds(5);
    }
    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\tThread: " + Thread.currentThread().getName());
    }
}
