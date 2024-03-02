package irish.bla.sec09;

import irish.bla.util.DefaultSubscriber;
import irish.bla.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec02OverlapAndDrop {
    public static void main(String[] args) {

        eventStream()
                // insteading of discrete 3-item jumps, this approach windows the data dropping the first element per window
                // .buffer(3) => buffer(3,3) (get 3 items and skip 3 items)
//                .buffer(3, 1)

                // or can be used for a sampling approach: every 5 items, get 3
                .buffer(3, 5)
                .subscribe(DefaultSubscriber.newInstance());
        Util.sleepSeconds(60);

    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(300))
                .map(i -> "event-" + i);
    }
}
