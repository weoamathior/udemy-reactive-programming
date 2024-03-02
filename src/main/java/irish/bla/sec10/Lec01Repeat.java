package irish.bla.sec10;

import irish.bla.util.DefaultSubscriber;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class Lec01Repeat {
    private static AtomicInteger atomicInteger = new AtomicInteger(1);
    public static void main(String[] args) {
        getInts()
//                .repeat(2)
//                .repeat() // infinitely re-subscribes
                .repeat(() -> atomicInteger.get() < 100) // test some condition
                .subscribe(DefaultSubscriber.newInstance());


    }
    private static Flux<Integer> getInts() {
        return Flux.range(1,3)
                .doOnSubscribe(s -> System.out.println("subscribed!"))
                .doOnComplete(() -> System.out.println("--completed!"))
                .map(i -> atomicInteger.getAndIncrement());
    }
}
