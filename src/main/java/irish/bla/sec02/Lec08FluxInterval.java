package irish.bla.sec02;

import irish.bla.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec08FluxInterval {
    public static void main(String[] args) {
        // happening ina different thread pool
        Flux.interval(Duration.ofSeconds(1))
                .subscribe(Util.onNext());

        // block main thread 
        Util.sleepSeconds(5);
    }
}
