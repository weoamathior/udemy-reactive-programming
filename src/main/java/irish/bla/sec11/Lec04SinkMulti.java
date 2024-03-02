package irish.bla.sec11;

import irish.bla.util.DefaultSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class Lec04SinkMulti {
    public static void main(String[] args) {
        Sinks.Many<Object> sink = Sinks.many()
                .multicast()
                .onBackpressureBuffer();

        // handle through which subscribers receive items
        Flux<Object> flux = sink.asFlux();
        flux.subscribe(DefaultSubscriber.newInstance("sam"));

        sink.tryEmitNext("hello world");
        sink.tryEmitNext("thing 1");

        flux.subscribe(DefaultSubscriber.newInstance("mike"));
        sink.tryEmitNext("thing 2");
        sink.tryEmitNext("last thing");

    }
}
