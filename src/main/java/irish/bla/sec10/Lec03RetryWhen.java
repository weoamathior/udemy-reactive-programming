package irish.bla.sec10;

import irish.bla.util.DefaultSubscriber;
import irish.bla.util.Util;
import reactor.core.publisher.Flux;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class Lec03RetryWhen {
    private static AtomicInteger atomicInteger = new AtomicInteger(1);
    public static void main(String[] args) {
        getInts()
                .retryWhen(Retry.fixedDelay(2, Duration.ofSeconds(3)))
                .subscribe(DefaultSubscriber.newInstance());

        Util.sleepSeconds(60);

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
