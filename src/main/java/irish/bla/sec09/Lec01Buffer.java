package irish.bla.sec09;

import irish.bla.util.DefaultSubscriber;
import irish.bla.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec01Buffer {
    public static void main(String[] args) {

        eventStream()
                // collects the item and provides a Flux<List<String>>
                .buffer(5)
                .subscribe(DefaultSubscriber.newInstance());
        Util.sleepSeconds(60);

    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(300))
                // .take(3) overrides the buffer(5) and returns only the first three events
//                .take(3)
        //DefaultSubscriber received: [event-0, event-1, event-2]
        //DefaultSubscriber completed
//
        //
                .map(i -> "event-" + i);
    }
}