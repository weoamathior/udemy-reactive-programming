package irish.bla.sec06;

import irish.bla.util.DefaultSubscriber;
import irish.bla.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec07FluxInterval {
    public static void main(String[] args) {
        Flux.interval(Duration.ofSeconds(1))
                .subscribe(DefaultSubscriber.newInstance());

        // why do we need this for the above?  Internally, Flux.interval uses Schedulers.parallel()
        Util.sleepSeconds(10);
    }
}
