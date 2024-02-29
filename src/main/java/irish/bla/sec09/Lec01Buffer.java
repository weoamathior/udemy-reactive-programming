package irish.bla.sec09;

import irish.bla.util.DefaultSubscriber;
import irish.bla.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec01Buffer {
    public static void main(String[] args) {

        eventStream()
                // collects the item and provides a Flux<List<String>>

                // bufferTimaeout - either maxSize or duration, whichever comes first
                .bufferTimeout(5, Duration.ofSeconds(2))
//                .buffer(Duration.ofSeconds(2))
                .subscribe(DefaultSubscriber.newInstance());
        Util.sleepSeconds(60);

    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(1000))
                .map(i -> "event-" + i);
    }
}