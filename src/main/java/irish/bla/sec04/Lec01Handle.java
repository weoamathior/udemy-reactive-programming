package irish.bla.sec04;

import irish.bla.util.DefaultSubscriber;
import reactor.core.publisher.Flux;

public class Lec01Handle {
    public static void main(String[] args) {
        // handle = filter + map

        Flux.range(1,20)
                .handle(((integer, synchronousSink) -> {
                    if (integer % 2 == 0) { // filter-like
                        synchronousSink.next(integer);
                    } else { // map like
                        synchronousSink.next(integer + "a");
                    }
                }))
                .subscribe(DefaultSubscriber.newInstance());
    }
}
