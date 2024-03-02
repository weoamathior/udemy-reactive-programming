package irish.bla.sec01;

import reactor.core.publisher.Mono;

public class Lec01MonoJust {
    public static void main(String[] args) {
        //publisher
        Mono<Integer> mono = Mono.just(1);
        // nothing happens until you subscribe!

        System.out.println(mono);

        mono.subscribe(i -> System.out.println("received " + i));
    }
}
