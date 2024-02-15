package irish.bla.sec04;

import irish.bla.util.DefaultSubscriber;
import irish.bla.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec05Delay {
    public static void main(String[] args) {

        Flux.range(1,100)
                .log()
                .delayElements(Duration.ofSeconds(1))
                .subscribe(DefaultSubscriber.newInstance());

        Util.sleepSeconds(60);
    }
}
