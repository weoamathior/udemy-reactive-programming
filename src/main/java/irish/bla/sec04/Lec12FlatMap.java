package irish.bla.sec04;

import irish.bla.sec04.helper.OrderService;
import irish.bla.sec04.helper.UserService;
import irish.bla.util.DefaultSubscriber;
import irish.bla.util.Util;

public class Lec12FlatMap {
    public static void main(String[] args) {
        UserService.getUsers()
//                .map(user -> OrderService.getOrders(user.getUserId()))// flux per user in this case
                .flatMap(user -> OrderService.getOrders(user.getUserId()))
                .subscribe(DefaultSubscriber.newInstance());

        Util.sleepSeconds(10);
    }
}
