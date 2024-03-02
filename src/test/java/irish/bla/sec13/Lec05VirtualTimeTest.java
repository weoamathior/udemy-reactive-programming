package irish.bla.sec13;

import irish.bla.sec09.helper.BookOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;

public class Lec05VirtualTimeTest {
    @Test
    void test1() {

        StepVerifier.withVirtualTime(() -> timeconsumingFlux())
                .thenAwait(Duration.ofSeconds(30)) // simulate 30 seconds passing.  magic!
                .expectNext("1a","2a","3a","4a")
                .verifyComplete();
    }
    @Test
    void test2() {

        StepVerifier.withVirtualTime(() -> timeconsumingFlux())
                .expectSubscription()
                .expectNoEvent(Duration.ofSeconds(4))
                .thenAwait(Duration.ofSeconds(30)) // simulate 30 seconds passing.  magic!
                .expectNext("1a","2a","3a","4a")
                .verifyComplete();
    }
    Flux<String> timeconsumingFlux() {
        return Flux.range(1,4)
                .delayElements(Duration.ofSeconds(5))
                .map(i -> i + "a");
    }
}
