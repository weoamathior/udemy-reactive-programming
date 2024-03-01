package irish.bla.sec12;

import irish.bla.sec12.helper.BookService;
import irish.bla.sec12.helper.UserService;
import irish.bla.util.DefaultSubscriber;
import reactor.util.context.Context;

public class Lec02ContextRateLimiterDemo {
    public static void main(String[] args) {
        BookService.getBook()
                .repeat(2)
                .contextWrite(UserService.userCategoryContext())
                .contextWrite(Context.of("user","mike"))
//                .contextWrite(Context.of("user","sam"))
                .subscribe(DefaultSubscriber.newInstance());
    }
}
