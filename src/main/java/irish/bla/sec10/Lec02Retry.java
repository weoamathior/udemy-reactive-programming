package irish.bla.sec10;

import irish.bla.util.DefaultSubscriber;
import irish.bla.util.Util;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class Lec02Retry {
    private static AtomicInteger atomicInteger = new AtomicInteger(1);
    public static void main(String[] args) {
        getInts()
                .retry(2)
                .subscribe(DefaultSubscriber.newInstance());


    }
    private static Flux<Integer> getInts() {
        return Flux.range(1,3)
                .doOnSubscribe(s -> System.out.println("subscribed!"))
                .doOnComplete(() -> System.out.println("--completed!"))
                .map(i -> atomicInteger.getAndIncrement())
                .map(i ->i/ (Util.faker().random().nextInt(1,5) > 3 ? 0 : 1))
                .doOnError(err -> System.err.println("--error"));
    }
}
