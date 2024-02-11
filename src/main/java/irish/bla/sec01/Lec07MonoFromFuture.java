package irish.bla.sec01;

import irish.bla.util.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Lec07MonoFromFuture {
    public static void main(String[] args) {

        Mono.fromFuture(getName()).subscribe(Util.onNext());

        Util.sleepSeconds(1);

    }
    private static CompletableFuture<String> getName() {
        return CompletableFuture.supplyAsync(() -> Util.faker().name().fullName());
    }
}
