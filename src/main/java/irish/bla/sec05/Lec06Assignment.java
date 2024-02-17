package irish.bla.sec05;

import irish.bla.sec05.assignment.InventoryService;
import irish.bla.sec05.assignment.OrderService;
import irish.bla.sec05.assignment.RevenueService;
import irish.bla.util.DefaultSubscriber;
import irish.bla.util.Util;

public class Lec06Assignment {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        RevenueService revenueService = new RevenueService();
        InventoryService inventoryService = new InventoryService();

        // inventory and revenue observe the order stream
        orderService.orderStream().subscribe(revenueService.subscribeOrderStream());
        orderService.orderStream().subscribe(inventoryService.subscribeOrderStream());

        inventoryService.inventoryStream()
                .subscribe(DefaultSubscriber.newInstance("inventory"));

        revenueService.revenueStream()
                .subscribe(DefaultSubscriber.newInstance("revenue"));

        Util.sleepSeconds(60);
    }
}
