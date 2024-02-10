package irish.bla.sec01;

import com.github.javafaker.Faker;

public class FakerDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String name = Faker.instance().name().fullName();
            System.out.println(name);
        }
    }
}
