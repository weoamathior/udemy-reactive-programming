package irish.bla.sec08.helper;

import irish.bla.util.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {
    private List<String> cache = new ArrayList<>();
    public Flux<String> generateName() {
        return Flux.generate(stringSynchronousSink -> {
            String name = Util.faker().name().firstName();
            System.out.println("generated: " + name);
            Util.sleepSeconds(1);
            cache.add(name);
            stringSynchronousSink.next(name);
        })
                .cast(String.class)
                .startWith(getFromCache());
    }

    private Flux<String> getFromCache() {
        return Flux.fromIterable(cache);
    }
}
