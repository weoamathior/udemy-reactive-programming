package irish.bla.sec01;

import irish.bla.util.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;

public class Lec05MonoFromSupplier {
    public static void main(String[] args) {
        // getName is not invoked lazily
        // use 'just' method only when data is already available
//        Mono<String> mono = Mono.just(getName());

        // the lazy way using supplier
        Mono<String> mono = Mono.fromSupplier(() -> getName());

        mono.subscribe(Util.onNext());

        // Supplier and Callable are similar
        Callable<String> callable = () -> getName();
        Mono.fromCallable(callable).subscribe(Util.onNext());


    }

    private static String getName() {
        System.out.println("generating name..");
        return Util.faker().name().fullName();
    }
}
