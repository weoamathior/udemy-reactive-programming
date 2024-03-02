package irish.bla.sec02;

import irish.bla.util.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Lec04FluxFromStream {
    public static void main(String[] args) {

        List<Integer> ints = List.of(1, 2, 3, 4, 5);

        Stream<Integer> stream = ints.stream();

//        stream.forEach(System.out::println);
        // once stream is consumed it cannot be reused
//        stream.forEach(System.out::println);

        Flux<Integer> flux = Flux.fromStream(() -> ints.stream());
//        Flux<Integer> flux = Flux.fromStream(stream);

        flux.subscribe(Util.onNext(),Util.onError(),Util.onComplete());
        flux.subscribe(Util.onNext(),Util.onError(),Util.onComplete());

    }
}
