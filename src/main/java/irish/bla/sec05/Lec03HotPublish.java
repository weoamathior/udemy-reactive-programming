package irish.bla.sec05;

import irish.bla.util.DefaultSubscriber;
import irish.bla.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec03HotPublish {
    public static void main(String[] args) {

        Flux<String> flux = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(2))

                // .share() => .publish().refCount(1)
                .publish()
//                .refCount(1); // minSubsribers => at least one subscriber for the data to be emitted
        .refCount(2); // 2 subscribers will wait until both sam and becky have subscribed before emitting data


        flux.subscribe(DefaultSubscriber.newInstance("sam"));
        Util.sleepSeconds(5);

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
