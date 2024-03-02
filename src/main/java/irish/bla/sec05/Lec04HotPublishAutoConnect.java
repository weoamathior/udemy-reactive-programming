package irish.bla.sec05;

import irish.bla.util.DefaultSubscriber;
import irish.bla.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec04HotPublishAutoConnect {
    public static void main(String[] args) {

        Flux<String> flux = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(1))

                .publish()
                // subscribers unnecessary to begin emitting data
                .autoConnect(0);

        Util.sleepSeconds(3);

        // sam has already missed three scenes
        flux.subscribe(DefaultSubscriber.newInstance("sam"));
        Util.sleepSeconds(10); // sam completes the movie and subscription ends

        // beck will not see anything
        System.out.println("becky about to join");
        flux.subscribe(DefaultSubscriber.newInstance("becky"));
        // becky's is a new subscription and movie starts from beginning

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