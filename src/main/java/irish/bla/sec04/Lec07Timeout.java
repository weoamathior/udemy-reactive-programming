package irish.bla.sec04;

import irish.bla.util.DefaultSubscriber;
import irish.bla.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec07Timeout {
    public static void main(String[] args) {

        getOrderNumbers()
                .timeout(Duration.ofSeconds(2),fallback())
                .subscribe(DefaultSubscriber.newInstance());

        Util.sleepSeconds(60);

    }

    private static Flux<Integer> fallback() {
        return Flux.range(100,10)
                .delayElements(Duration.ofMillis(200));
    }

    private static Flux<Integer> getOrderNumbers() {

        return Flux.range(1,10)
                .delayElements(Duration.ofMillis(5000));

    }
}
