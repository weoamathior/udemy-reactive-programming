package irish.bla.sec11;

import irish.bla.util.DefaultSubscriber;
import irish.bla.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.time.Duration;

public class Lec05SinkMultiDirectAll {
    public static void main(String[] args) {
        System.setProperty("reactor.bufferSize.small", "16");

        Sinks.Many<Object> sink = Sinks.many()
                .multicast()
//                .directAllOrNothing()
                .directBestEffort();

        // handle through which subscribers receive items
        Flux<Object> flux = sink.asFlux();
        flux.subscribe(DefaultSubscriber.newInstance("sam"));
        flux.delayElements(Duration.ofMillis(200))
                .subscribe(DefaultSubscriber.newInstance("mike"));

        for (int i = 0; i < 100; i++) {
            sink.tryEmitNext(i);
        }

        Util.sleepSeconds(10);

    }
}
