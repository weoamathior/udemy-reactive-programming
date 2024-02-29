package irish.bla.sec09;

import irish.bla.sec09.helper.BookOrder;
import irish.bla.sec09.helper.RevenueReport;
import irish.bla.util.DefaultSubscriber;
import irish.bla.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Lec03Assignment {

    public static void main(String[] args) {

        Set<String> allowedCategories = Set.of(
                "Science fiction",
                "Fantasy",
                "Suspense/Thriller"
        );

        bookStream()
                .filter(book -> {
                    return allowedCategories.contains(book.getCategory());
                })
                .buffer(Duration.ofSeconds(5))
                .map(list -> revenueCalc(list))
                .subscribe(DefaultSubscriber.newInstance());

        Util.sleepSeconds(60);


    }

    private static RevenueReport revenueCalc(List<BookOrder> orders) {
        Map<String, Double> collect = orders
                .stream()
                .collect(Collectors.groupingBy(BookOrder::getCategory, Collectors.summingDouble(BookOrder::getPrice)));
        return new RevenueReport(collect);
    }

    private static Flux<BookOrder> bookStream() {
        return Flux.interval(Duration.ofMillis(200))
                .map(i -> BookOrder.create());
    }
}
