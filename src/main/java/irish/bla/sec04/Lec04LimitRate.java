package irish.bla.sec04;

import irish.bla.util.DefaultSubscriber;
import reactor.core.publisher.Flux;

public class Lec04LimitRate {
    public static void main(String[] args) {


        Flux.range(1,1000)
                .log()
//                .limitRate(100) // on 75% -> 75 more items are requested (the default)
//                .limitRate(100, 99) // on 99% -> 99 more items requested
                .limitRate(100, 0) // setting 'lowTide=0' means 100 more items requested when the prior 100 are consumed
                .subscribe(DefaultSubscriber.newInstance());
    }
}
