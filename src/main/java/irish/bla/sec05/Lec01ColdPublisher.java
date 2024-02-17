package irish.bla.sec05;

import irish.bla.util.DefaultSubscriber;
import irish.bla.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec01ColdPublisher {
    public static void main(String[] args) {

        Flux<String> flux = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(2));

        flux.subscribe(DefaultSubscriber.newInstance("sam"));
        Util.sleepSeconds(3);

        flux.subscribe(DefaultSubscriber.newInstance("becky"));

        Util.sleepSeconds(20);

    }


    // like netflix!
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
