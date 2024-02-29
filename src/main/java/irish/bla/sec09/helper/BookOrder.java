package irish.bla.sec09.helper;

import com.github.javafaker.Book;
import irish.bla.util.Util;
import lombok.Getter;

@Getter
public class BookOrder {
    private String title;
    private String author;
    private String category;
    private Double price;

    public static BookOrder create() {
        BookOrder order = new BookOrder();
        Book book = Util.faker().book();
        order.title = book.title();
        order.author = book.author();
        order.category = book.genre();
        order.price = Double.parseDouble(Util.faker().commerce().price());
        return order;
    }
}
