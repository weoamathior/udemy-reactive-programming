package irish.bla.sec09;

import irish.bla.sec09.assignment.OrderProcessor;
import irish.bla.sec09.assignment.OrderService;
import irish.bla.sec09.assignment.PurchaseOrder;
import irish.bla.util.DefaultSubscriber;
import irish.bla.util.Util;
import reactor.core.publisher.Flux;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class Lec06Assignment {
    public static void main(String[] args) {
        Map<String, Function<Flux<PurchaseOrder>, Flux<PurchaseOrder>>> map = Map.of(
                "Sports", OrderProcessor.automotiveProcessor(),
                "Health", OrderProcessor.kidsProcessor()
        );

        Set<String> keys = map.keySet();

        OrderService.orderStream()
//                .log()
                .filter(p -> keys.contains(p.getCategory()))
//                .log()
                .groupBy(PurchaseOrder::getCategory) // creates flux with 2 keys
                .flatMap(gf -> map.get(gf.key()).apply(gf))
                .subscribe(DefaultSubscriber.newInstance());

        Util.sleepSeconds(60);
    }


}
