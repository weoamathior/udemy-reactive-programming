package irish.bla.sec02.helper;

import irish.bla.util.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {
//    public static List<String> getNames(int count) {
//        List<String> list = new ArrayList<>(count);
//        for (int i = 0; i < count; i++) {
//            list.add(newName());
//        }
//        return list;
//    }

    public static Flux<String> getNames(int count) {
        return Flux.range(0, count)
                .map(i -> newName());
    }
    public static String newName() {
        Util.sleepSeconds(1);
        return Util.faker().name().fullName();
    }
}
