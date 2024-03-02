package irish.bla.sec05;

import irish.bla.util.DefaultSubscriber;
import irish.bla.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec05HotPublishCache {

    public static void main(String[] args) {

        Flux<String> flux = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(1))

                // .cache => .publish().replay()
//                        .cache(); // default cache size is int max value
                        .cache(2); // just keep two items

        Util.sleepSeconds(2);

        flux.subscribe(DefaultSubscriber.newInstance("sam"));
        Util.sleepSeconds(10);

        System.out.println("becky about to join");
        flux.subscribe(DefaultSubscriber.newInstance("becky"));

        Util.sleepSeconds(20);

    }

    // like a movie theater ... if come late then you'll miss stuff
    private static Stream<String> getMovie() {
        System.out.println("Got movie streaming request");
        return Stream.of(
                "scene 1",
                "scene 2",
                "scene 3",
                "scene 4",
                "scene 5",
                "scene 6"
        );

    }
}