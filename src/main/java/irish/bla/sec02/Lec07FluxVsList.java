package irish.bla.sec02;

import irish.bla.sec02.helper.NameGenerator;
import irish.bla.util.Util;

import java.util.List;

public class Lec07FluxVsList {
    public static void main(String[] args) {
        // you'll wait (up front) five seconds
//        List<String> names = NameGenerator.getNames(5);
//        System.out.println(names);

        // As soon as something is ready the data is published
        NameGenerator.getNames(5)
                .subscribe(Util.onNext());
    }
}
