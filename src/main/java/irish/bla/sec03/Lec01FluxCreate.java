package irish.bla.sec03;

import irish.bla.util.DefaultSubscriber;
import irish.bla.util.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxCreate {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            String country = null;
            do {
                country = Util.faker().country().name();
                fluxSink.next(country);

            }while (!country.equalsIgnoreCase("canada"));


                })
                .subscribe(DefaultSubscriber.newInstance());
    }
}
