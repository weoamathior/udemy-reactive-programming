package irish.bla.sec11;

import irish.bla.util.DefaultSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class Lec01SinkOne {
    public static void main(String[] args) {
        //mono -> emit empty, one or error
        Sinks.One<Object> one = Sinks.one();

        Mono<Object> mono = one.asMono();

        mono.subscribe(DefaultSubscriber.newInstance("sam"));
        mono.subscribe(DefaultSubscriber.newInstance("jill"));

        one.tryEmitValue("hi");
//        one.tryEmitEmpty();
//        one.tryEmitError(new RuntimeException("oh no"));

//        one.emitValue("hi", (signalType, emitResult) -> {
//            System.out.println(signalType.name());
//            System.out.println(emitResult.name());
//            return false;
//        });
//
//        one.emitValue("hi", (signalType, emitResult) -> {
//            System.out.println(signalType.name());
//            System.out.println(emitResult.name());
//            return false;
//        });

    }
}
