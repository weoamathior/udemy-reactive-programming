package irish.bla.sec03;

import irish.bla.util.DefaultSubscriber;
import reactor.core.publisher.Flux;

public class Lec03TakeOperator {
    public static void main(String[] args) {
        //map
        //filter

        Flux.range(1,10)
                .log()
                .take(3)
                .log()
                .subscribe(DefaultSubscriber.newInstance());
    }
}
