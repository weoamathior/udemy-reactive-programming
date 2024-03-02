package irish.bla.sec13;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Lec02SVErrorTest {
    @Test
    void test1() {
        Flux<Integer> flux = Flux.just(1, 2, 3);
        Flux<Integer> ohNo = Flux.error(new RuntimeException("oh no"));
        Flux<Integer> concat = Flux.concat(flux, ohNo);

        StepVerifier.create(concat)
                // another way
                .expectNext(1, 2, 3)
                .verifyError();
    }
    @Test
    void test2() {
        Flux<Integer> flux = Flux.just(1, 2, 3);
        Flux<Integer> ohNo = Flux.error(new RuntimeException("oh no"));
        Flux<Integer> concat = Flux.concat(flux, ohNo);

        StepVerifier.create(concat)
                // another way
                .expectNext(1, 2, 3)
                .verifyError(RuntimeException.class);
//                .verifyError(IllegalStateException.class);
    }
    @Test
    void test3() {
        Flux<Integer> flux = Flux.just(1, 2, 3);
        Flux<Integer> ohNo = Flux.error(new RuntimeException("oh no"));
        Flux<Integer> concat = Flux.concat(flux, ohNo);

        StepVerifier.create(concat)
                // another way
                .expectNext(1, 2, 3)
                .verifyErrorMessage("oh no");
    }
}
