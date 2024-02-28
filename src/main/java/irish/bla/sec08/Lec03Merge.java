package irish.bla.sec08;

import irish.bla.sec08.helper.American;
import irish.bla.sec08.helper.Emirates;
import irish.bla.sec08.helper.Qatar;
import irish.bla.util.DefaultSubscriber;
import irish.bla.util.Util;
import reactor.core.publisher.Flux;

public class Lec03Merge {
    public static void main(String[] args) {
        Flux<String> merge = Flux.merge(
                Qatar.getFlights(),
                Emirates.getFlights(),
                American.getFlights()
        );

        merge.subscribe(DefaultSubscriber.newInstance());

        Util.sleepSeconds(10);
    }
}
