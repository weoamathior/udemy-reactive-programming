package irish.bla.sec03;

import irish.bla.sec03.helper.NameProducer;
import irish.bla.util.DefaultSubscriber;
import irish.bla.util.Util;
import reactor.core.publisher.Flux;

public class Lec08FluxPush {
    public static void main(String[] args) {
        NameProducer nameProducer = new NameProducer();
        // push not thread safe - use only for single thread producer
        Flux.push(nameProducer)
                .subscribe(DefaultSubscriber.newInstance());

        Runnable runnable = nameProducer::produce;

        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }

        Util.sleepSeconds(3);

    }
}
