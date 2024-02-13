package irish.bla.sec03;

import irish.bla.sec03.helper.NameProducer;
import irish.bla.util.DefaultSubscriber;
import reactor.core.publisher.Flux;

public class Lec02FluxCreateRefactor {
    public static void main(String[] args) {
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
