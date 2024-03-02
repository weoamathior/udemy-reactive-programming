package irish.bla.sec03;

import irish.bla.util.DefaultSubscriber;
import irish.bla.util.Util;
import reactor.core.publisher.Flux;

public class Lec06FluxGenerateAssignment {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
                    String country = Util.faker().country().name();
                    System.out.println("emitting " + country);
                    synchronousSink.next(country);
                    if (country.equalsIgnoreCase("canada")) {
                        synchronousSink.complete();
                    }

                })
                .subscribe(DefaultSubscriber.newInstance());
    }
}
