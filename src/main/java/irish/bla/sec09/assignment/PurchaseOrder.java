package irish.bla.sec09.assignment;

import irish.bla.util.Util;
import lombok.Data;

@Data
public class PurchaseOrder {
    private String item;
    private double price;
    private String category;

    public PurchaseOrder() {
        this.item = Util.faker().commerce().productName();
        this.price = Double.parseDouble(Util.faker().commerce().price());
        this.category = Util.faker().commerce().department();
    }
}
