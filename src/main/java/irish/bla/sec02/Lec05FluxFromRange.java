package irish.bla.sec02;

import irish.bla.util.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxFromRange {
    public static void main(String[] args) {

        Flux.range(1,10)
                .log()
                .map(i -> Util.faker().name().fullName())
                .log()
                .subscribe(Util.onNext());
    }
}
