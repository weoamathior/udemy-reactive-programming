package irish.bla.sec07;

import irish.bla.util.DefaultSubscriber;
import irish.bla.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec05BufferWithSize {
    public static void main(String[] args) {
        // From Queues reactor class.  Fiddling with the internal queue size
        System.setProperty("reactor.bufferSize.small", "16");

        Flux.create(fluxSink -> {
                    for (int i = 1; i < 201; i++) {
                        fluxSink.next(i);
                        System.out.println("pushed " + i);
                        Util.sleepMillis(1);

                    }
                    fluxSink.complete();
                })
                .onBackpressureBuffer(50, o -> System.out.println("dropped: " + o))
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> {
                    Util.sleepMillis(10);

                })
                .subscribe(DefaultSubscriber.newInstance());

        Util.sleepSeconds(10);
    }
}
