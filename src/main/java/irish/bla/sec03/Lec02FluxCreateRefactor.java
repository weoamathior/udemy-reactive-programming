package irish.bla.sec03;

import irish.bla.sec03.helper.NameProducer;
import irish.bla.util.DefaultSubscriber;
import irish.bla.util.Util;
import reactor.core.publisher.Flux;

public class Lec02FluxCreateRefactor {
    public static void main(String[] args) {
        NameProducer nameProducer = new NameProducer();
        Flux.create(nameProducer)
                .subscribe(DefaultSubscriber.newInstance());

        Runnable runnable = nameProducer::produce;

        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }

        Util.sleepSeconds(3);

    }
    public static void main0(String[] args) {
        NameProducer nameProducer = new NameProducer();
        Flux.create(nameProducer)
                .subscribe(DefaultSubscriber.newInstance());

        nameProducer.produce();
        nameProducer.produce();
        nameProducer.produce();
        nameProducer.produce();
        nameProducer.produce();
    }
}
