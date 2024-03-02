package irish.bla.sec11;

import irish.bla.util.DefaultSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class Lec02SinkUnicast {
    public static void main(String[] args) {
        // handle through which we push items
        Sinks.Many<Object> sink = Sinks.many()
                .unicast()
                .onBackpressureBuffer();

        // handle through which subscribers receive items
        Flux<Object> flux = sink.asFlux();
        flux.subscribe(DefaultSubscriber.newInstance("sam"));
        flux.subscribe(DefaultSubscriber.newInstance("mike"));

        sink.tryEmitNext("hello world");
        sink.tryEmitNext("thing 1");
        sink.tryEmitNext("thing 2");
        sink.tryEmitNext("last thing");


    }
}
