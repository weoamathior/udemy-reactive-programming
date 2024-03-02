package irish.bla.sec13;

import irish.bla.sec09.helper.BookOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;

public class Lec04AssertTest {
    @Test
    void test1() {
        Mono<BookOrder> bookOrderMono = Mono.fromSupplier(() -> BookOrder.create());

        StepVerifier.create(bookOrderMono)
                .assertNext(b -> Assertions.assertNotNull(b.getAuthor()))
                .verifyComplete();
    }
    @Test
    void test2() {
        Mono<BookOrder> bookOrderMono = Mono.fromSupplier(() -> BookOrder.create())
                .delayElement(Duration.ofSeconds(3));

        StepVerifier.create(bookOrderMono)
                .assertNext(b -> Assertions.assertNotNull(b.getAuthor()))
                .expectComplete()
                // provide a timeout
                .verify(Duration.ofSeconds(4));
    }
}
