package irish.bla.sec02;

import irish.bla.util.Util;
import reactor.core.publisher.Flux;

import java.util.Date;

public class Lec01FluxIntro {
    public static void main(String[] args) {
        Flux<Object> flux = Flux.just(1,2,Util.faker().name().firstName(), new Date());

        flux.subscribe(Util.onNext(),Util.onError(),Util.onComplete());
    }

    private static void example1() {
        Flux<Integer> flux = Flux.just(1,2,3,4,5);

        flux.subscribe(Util.onNext(),Util.onError(),Util.onComplete());
    }
}
