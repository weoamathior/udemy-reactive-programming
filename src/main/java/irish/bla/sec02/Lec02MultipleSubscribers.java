package irish.bla.sec02;


import irish.bla.util.Util;
import reactor.core.publisher.Flux;

public class Lec02MultipleSubscribers {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5);

        flux
                .subscribe(i -> System.out.println("sub 1 " + i));
        flux
                .subscribe(i -> System.out.println("sub 2 " + i));
    }
}
