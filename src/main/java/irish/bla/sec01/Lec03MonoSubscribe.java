package irish.bla.sec01;

import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {
    public static void main(String[] args) {
        Mono<String> ball = Mono.just("ball");

//        ball.subscribe();

        ball.subscribe(
                item -> System.out.println(item),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("all done!")
        );

    }
}
