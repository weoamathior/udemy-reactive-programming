package irish.bla.sec08;

import irish.bla.util.DefaultSubscriber;
import reactor.core.publisher.Flux;

public class Lec02Concat {
    public static void main(String[] args) {
        Flux<String> flux1 = Flux.just("a", "b");
        Flux<String> flux2 = Flux.just("c","d","e");
        Flux<String> fluxErr = Flux.error(new RuntimeException("oh no"));

//        Flux<String> flux3 = flux1.concatWith(flux2);
//        Flux<String> flux3 = Flux.concat(flux1, flux2); // same
//        Flux<String> flux3 = Flux.concat(flux1, fluxErr, flux2); // errors out
        Flux<String> flux3 = Flux.concatDelayError(flux1, fluxErr, flux2); // delays the error

        flux3.subscribe(DefaultSubscriber.newInstance());
    }
}
