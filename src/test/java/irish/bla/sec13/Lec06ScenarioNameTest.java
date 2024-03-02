package irish.bla.sec13;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.StepVerifierOptions;

import java.time.Duration;

public class Lec06ScenarioNameTest {
    @Test
    void test1() {

        Flux<String> flux = Flux.just("a", "b", "c");

        // provides some additional detail in the failure scenario
        StepVerifierOptions options = StepVerifierOptions.create().scenarioName("THIS IS AN ALPHABET TEST!");

        StepVerifier.create(flux,options)
                .expectNextCount(12)
                .verifyComplete();
    }
    @Test
    void test2() {

        Flux<String> flux = Flux.just("a", "b1", "c");

        StepVerifier.create(flux)
                .expectNext("a")
                .as("a-test")
                .expectNext("b")
                .as("b-test")
                .expectNext("c")
                .as("c-test")
                .verifyComplete();
    }
}
