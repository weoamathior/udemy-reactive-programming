package irish.bla.sec02.assignment;

import irish.bla.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class StockPricePublisher {
    public static void main(String[] args) {
            getPrice()
                    .subscribe(Util.onNext());
            Util.sleepSeconds(5);
    }
    public static Flux<Integer> getPrice() {
        AtomicInteger atomicInteger = new AtomicInteger(100);
        return Flux.interval(Duration.ofSeconds(1))
                .map(i -> atomicInteger.getAndAccumulate(
                        Util.faker().random().nextInt(-5,5),
                        Integer::sum
                ));
    }
}
