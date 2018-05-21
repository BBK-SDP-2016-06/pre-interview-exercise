import org.junit.platform.commons.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;

public class ShoppingCart {

    public BigDecimal Checkout(List<Fruit> items) {
        if (items == null) {
            return new BigDecimal("0");
        }
        else {
            return items.stream()
                    .map(Fruit::GetPrice)
                    .reduce(new BigDecimal("0"), BigDecimal::add);
        }
    }
}