package irish.bla.sec11;

import irish.bla.util.DefaultSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class Lec06SinkReplay {
    public static void main(String[] args) {
        Sinks.Many<Object> sink = Sinks.many()
                .replay().all();

        // handle through which subscribers receive items
        Flux<Object> flux = sink.asFlux();

        sink.tryEmitNext("hello world");
        sink.tryEmitNext("thing 1");
        flux.subscribe(DefaultSubscriber.newInstance("sam"));
        flux.subscribe(DefaultSubscriber.newInstance("mike"));
        sink.tryEmitNext("thing 2");

        flux.subscribe(DefaultSubscriber.newInstance("jill"));
        sink.tryEmitNext("last thing");

    }
}
