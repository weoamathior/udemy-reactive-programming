package irish.bla.sec04;

import irish.bla.util.DefaultSubscriber;
import irish.bla.util.Util;
import reactor.core.publisher.Flux;

public class Lec02HandleUntilCondition {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
            synchronousSink.next(Util.faker().country().name());
        })
                .map(Object::toString)
                .handle((s, sink) -> {
                    sink.next(s);
                    if ("canada".equalsIgnoreCase(s)) {
                        sink.complete();
                    }
                })
                .subscribe(DefaultSubscriber.newInstance());
    }
}
