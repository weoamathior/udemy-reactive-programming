package irish.bla.sec04;

import irish.bla.util.DefaultSubscriber;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec08DefaultIfEmpty {
    public static void main(String[] args) {
       getOrderNumbers()
               .filter(i -> i> 10) // nothing will match
               // provide some constant value
               .defaultIfEmpty(-100)
               .subscribe(DefaultSubscriber.newInstance());

    }
    private static Flux<Integer> getOrderNumbers() {

        return Flux.range(1,10);

    }
}
