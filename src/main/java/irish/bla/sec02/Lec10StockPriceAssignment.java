package irish.bla.sec02;

import irish.bla.sec02.assignment.StockPricePublisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

public class Lec10StockPriceAssignment {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        StockPricePublisher.getPrice()
                .subscribeWith(new Subscriber<Integer>() {
                    private Subscription subscription;

                    @Override
                    public void onSubscribe(Subscription subscription) {
                        this.subscription = subscription;
                        this.subscription.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(Integer val) {
                        System.out.println(LocalDateTime.now() + ": price= " + val);
                        if (val < 90 || 110 < val) {
                            this.subscription.cancel();
                            latch.countDown();
                        }

                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.err.println("oh no!" + throwable.getMessage());
                        latch.countDown();

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("all done");
                        latch.countDown();

                    }
                });

        latch.await();
    }
}
