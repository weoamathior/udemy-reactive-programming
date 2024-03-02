package irish.bla.sec02;

import irish.bla.util.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class Lec06Subscriber {
    public static void main(String[] args) {
        AtomicReference<Subscription> atomicReference = new AtomicReference<>();
        Flux.range(1,20)
                .log()
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("Received sub " + subscription);
                        atomicReference.set(subscription);

                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext: " + integer);

                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.err.println("err: " + throwable.getMessage());

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("complete! ");

                    }
                });

        Util.sleepSeconds(3);
        atomicReference.get().request(3);
        Util.sleepSeconds(5);
        atomicReference.get().request(3);
        Util.sleepSeconds(5);
        System.out.println("going to cancel ...");
        atomicReference.get().cancel();
        Util.sleepSeconds(3);
        // subscription is canceled.  No more items can be requested
        atomicReference.get().request(4);
        Util.sleepSeconds(3);

    }
}
