package irish.bla.sec03;

import irish.bla.util.DefaultSubscriber;
import irish.bla.util.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxGenerate {
    public static void main(String[] args) {


        // using synchronoussink: can emit only one item at a time.
        Flux.generate(synchronousSink -> {
            // note there is no loop to maintain (compare to flux create example)
            // Flux.generate will continue to invoke this code again and again
            synchronousSink.next(Util.faker().country().name());
                   // synchronousSink.next(Util.faker().country().name()); // trying to emit 2 items results in error
        })
                .take(3)
                .subscribe(DefaultSubscriber.newInstance());
    }
}
