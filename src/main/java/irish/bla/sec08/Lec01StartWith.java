package irish.bla.sec08;

import irish.bla.sec08.helper.NameGenerator;
import irish.bla.util.DefaultSubscriber;

public class Lec01StartWith {
    public static void main(String[] args) {

        NameGenerator nameGenerator = new NameGenerator();

        // generate 'fresh' names and cache
        nameGenerator.generateName()
                .take(2)
                .subscribe(DefaultSubscriber.newInstance("sam"));

        // cache is populated.  'startWith' takes over and returns the prior two names
        nameGenerator.generateName()
                .take(2)
                .subscribe(DefaultSubscriber.newInstance("mike"));

        nameGenerator.generateName()
                .take(3)
                .subscribe(DefaultSubscriber.newInstance("jake"));

        nameGenerator.generateName()
                .filter(s -> s.startsWith("A"))
                .take(1)
                .subscribe(DefaultSubscriber.newInstance("jose"));

    }
}
