package irish.bla.sec04;

import irish.bla.sec04.helper.Person;
import irish.bla.util.DefaultSubscriber;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class Lec11SwitchOnFirst {
    public static void main(String[] args) {
        getPerson()
                // take some action if the first signal meets some criteria
                // here: if the first person's age is less than 10 then apply our custom transform
                .switchOnFirst(((signal, personFlux) -> {
                    return signal.isOnNext() && signal.get().getAge() > 10 ? personFlux : applyFilterMap().apply(personFlux);
                }))
                .subscribe(DefaultSubscriber.newInstance());

    }

    public static Flux<Person> getPerson() {
        return Flux.range(1,10)
                .map(i -> Person.random());
    }

    public static Function<Flux<Person>,Flux<Person>> applyFilterMap() {
        return flux -> flux
                .filter(p -> p.getAge() > 10)
                .doOnNext(p -> p.setName(p.getName().toUpperCase()))
                .doOnDiscard(Person.class, p -> System.out.println("NOPE: " + p));
    }
}
