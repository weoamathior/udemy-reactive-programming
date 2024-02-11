package irish.bla.sec01;

import irish.bla.util.Util;
import reactor.core.publisher.Mono;

public class Lec06SupplierRefactor {
    public static void main(String[] args) {
        getName(1);
        getName(2).subscribe(Util.onNext());
        getName(3);

    }
    private static Mono<String> getName(int what) {
        System.out.println("entered 'getName' " + what);
        return Mono.fromSupplier(() -> {
            System.out.println("generating name...");
            Util.sleepSeconds(3);
            return Util.faker().name().fullName();
        }).map(String::toUpperCase);
    }
}
