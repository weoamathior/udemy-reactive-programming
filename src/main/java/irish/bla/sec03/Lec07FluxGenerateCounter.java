package irish.bla.sec03;

import irish.bla.util.DefaultSubscriber;
import irish.bla.util.Util;
import reactor.core.publisher.Flux;

public class Lec07FluxGenerateCounter {
    public static void main(String[] args) {
        Flux.generate(
                () -> 1, // initial state
                (counter, sink) -> {
                    String country = Util.faker().country().name();
                    sink.next(country);
                    if (counter >=10 || country.equalsIgnoreCase("canada")) {
                        sink.complete();
                    }

                    return counter + 1;
                }

        )
                .subscribe(DefaultSubscriber.newInstance());
    }
}
