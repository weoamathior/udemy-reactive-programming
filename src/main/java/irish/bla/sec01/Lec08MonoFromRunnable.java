package irish.bla.sec01;

import irish.bla.util.Util;
import reactor.core.publisher.Mono;

public class Lec08MonoFromRunnable {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("runnable!");

        Mono.fromRunnable(takeSomeTime(3))
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }

    private static Runnable takeSomeTime(int time) {
        return () -> {
            System.out.println("running!");
            Util.sleepSeconds(time);
        };
    }
}
