package irish.bla.sec11.assignment;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.function.Consumer;

public class SlackMember {
    @Getter(AccessLevel.PACKAGE)
    private String name;

    @Setter(AccessLevel.PACKAGE)
    private Consumer<String> messageConsumer;
    public SlackMember(String n) {
        this.name = n;
    }

    void receive(String msg) {
        System.out.println(msg);
    }
    public void says(String msg) {
        this.messageConsumer.accept(msg);
    }

    @Override
    public String toString() {
        return this.name;
    }

}
