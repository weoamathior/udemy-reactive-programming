package irish.bla.sec04.helper;

import irish.bla.util.Util;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private int age;

    public static Person random() {
        return new Person(Util.faker().name().fullName(), Util.faker().random().nextInt(1,100));
    }
}
