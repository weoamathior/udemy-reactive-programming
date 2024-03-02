package irish.bla.sec03;

import irish.bla.util.DefaultSubscriber;
import irish.bla.util.Util;
import reactor.core.publisher.Flux;

public class Lec04FluxCreateDownstreamIssueFix {
    public static void main(String[] args) {

        Flux.create(fluxSink -> {
                    String country = null;
                    do {
                        country = Util.faker().country().name();
                        System.out.println("emitting country: " + country);
                        fluxSink.next(country);

                    } while (!country.equalsIgnoreCase("canada") && !fluxSink.isCancelled());
                    fluxSink.complete();


                })
                .take(3)
                .subscribe(DefaultSubscriber.newInstance());
    }
}
