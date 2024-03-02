package irish.bla.sec04;

import irish.bla.sec04.helper.Person;
import irish.bla.util.DefaultSubscriber;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class Lec10Transform {
    public static void main(String[] args) {
        getPerson()
                .transform(applyFilterMap())
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
