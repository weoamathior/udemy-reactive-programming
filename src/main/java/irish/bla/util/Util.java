package irish.bla.util;

import com.github.javafaker.Faker;

import java.util.Objects;
import java.util.function.Consumer;

public class Util {
    public static Faker FAKER = Faker.instance();

    public static Consumer<Object> onNext() {
        return o -> System.out.println("Received: " + o);
    }

    public static Consumer<Throwable> onError() {
        return o -> System.err.println("Error: " + o.getMessage());
    }

    public static Runnable onComplete() {
        return () -> System.out.println("all done!");
    }

    public static Faker faker() {
        return FAKER;
    }
}
