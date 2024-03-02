package irish.bla.sec09;

import irish.bla.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec05GroupBy {
    public static void main(String[] args) {
        Flux.range(1, 30)
                .delayElements(Duration.ofSeconds(1))
                .groupBy(b -> b % 2) // key
                .subscribe(gf -> process(gf, gf.key()));

        Util.sleepSeconds(60);
    }

    private static void process(Flux<Integer> flux, int key) {
        System.out.println("invoking process");
        flux.subscribe(i -> System.out.println("key="+key+ " item="+i));
    }
}
