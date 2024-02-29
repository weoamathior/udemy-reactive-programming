package irish.bla.sec09;

import irish.bla.util.DefaultSubscriber;
import irish.bla.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class Lec04Window {
    private static AtomicInteger atomicInteger = new AtomicInteger(1);
    public static void main(String[] args) {

        eventStream()
                .window(Duration.ofSeconds(2))
//                .window(5)
                .flatMap(stringFlux -> saveEvents(stringFlux))
                .subscribe(DefaultSubscriber.newInstance());
        Util.sleepSeconds(60);

    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(500))
                .map(i -> "event-" + i);
    }

    private static Mono<Integer> saveEvents(Flux<String> flux) {
        return flux.doOnNext(e -> System.out.println("saving event" + e))
                .doOnComplete(() -> System.out.println("saved batch\n------"))
                .then(Mono.just(atomicInteger.getAndIncrement()));
    }
}