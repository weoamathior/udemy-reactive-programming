package irish.bla.util;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public class DefaultSubscriber implements Subscriber<Object> {
    private Subscription subscription;
    private String name = DefaultSubscriber.class.getSimpleName();

    public DefaultSubscriber(String n) {this.name = n;}
    public DefaultSubscriber(){}

    @Override
    public void onSubscribe(Subscription s) {
        this.subscription = s;
        s.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Object o) {
        System.out.println(this.name + " received: " + o);

    }

    @Override
    public void onError(Throwable t) {
        System.err.println(this.name + " Error: "  + t.getMessage());

    }

    @Override
    public void onComplete() {
        System.out.println(this.name + " completed");
    }

    public static Subscriber<Object> newInstance() {
        return new DefaultSubscriber();
    }
    public static Subscriber<Object> newInstance(String name) {
        return new DefaultSubscriber(name);
    }
}
