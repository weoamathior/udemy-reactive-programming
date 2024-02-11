package irish.bla.sec02;

import irish.bla.util.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class Lec03FluxFromArrayOrList {
    public static void main(String[] args) {

        Integer[] arr = {2,4,6,7};

        Flux.fromArray(arr)
                .subscribe(Util.onNext());

    }

    private static void example1() {
        // like "just" because data is already present
        List<String> list = Arrays.asList("a", "b", "c");

        Flux.fromIterable(list)
                .subscribe(Util.onNext());

    }
}
