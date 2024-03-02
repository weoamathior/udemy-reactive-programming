package irish.bla.sec13;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Lec03SVRangeTest {
    @Test
    void test2() {
        Flux<Integer> range = Flux.range(1,50);

        StepVerifier.create(range)
                // expect onNext signals
                .expectNextCount(50)
                .verifyComplete();
    }
    @Test
    void test3() {
        Flux<Integer> range = Flux.range(1,50);

        StepVerifier.create(range)
                // continue to process while it satisfies this condition 
                .thenConsumeWhile(i -> i < 100)
                .verifyComplete();
    }
}
