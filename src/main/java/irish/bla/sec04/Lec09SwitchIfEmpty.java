package irish.bla.sec04;

import irish.bla.util.DefaultSubscriber;
import reactor.core.publisher.Flux;

public class Lec09SwitchIfEmpty {
    public static void main(String[] args) {
        getOrderNumbers()
                .filter(i -> i> 10) // nothing will match
                // like defaultIfEmpty but returns a publisher type
                .switchIfEmpty(fallback())
//                .defaultIfEmpty(-100)
                .subscribe(DefaultSubscriber.newInstance());

    }
    private static Flux<Integer> getOrderNumbers() {
        return Flux.range(1,10);
    }
    private static Flux<Integer> fallback() {
        return Flux.range(20,5);
    }
}
