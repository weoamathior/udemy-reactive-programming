package irish.bla.sec08;

import irish.bla.util.DefaultSubscriber;
import irish.bla.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec06Assignment {
    public static void main(String[] args) {

        final int carPrice = 10000;
        Flux.combineLatest(month(), demand(), (month, demand) -> {

            return (carPrice - (month * 100)) * demand;

        })
                .subscribe(DefaultSubscriber.newInstance());

        Util.sleepSeconds(20);

    }

    static Flux<Long> month() {
        return Flux.interval(Duration.ZERO, Duration.ofSeconds(1));
    }

    static Flux<Double> demand() {
        return Flux.interval(Duration.ofSeconds(3))
                .map(i -> Util.faker().random().nextInt(80,120)/100d)
                .startWith(1d);
    }
}
