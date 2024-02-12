package irish.bla.sec02;

import irish.bla.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec09FluxFromMono {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("a");

        Flux<String> flux = Flux.from(mono);

        flux.subscribe(Util.onNext());

        // flux to mono
        Flux.range(1,10)
                .filter(i -> i > 3)
                .next() // very first item (given prior filters)
                .subscribe(Util.onNext());
    }
}
