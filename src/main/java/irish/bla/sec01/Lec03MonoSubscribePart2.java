package irish.bla.sec01;

import irish.bla.util.Util;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribePart2 {
    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just("ball")
                .map(String::length)
                .map( i -> i / 0);

        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
