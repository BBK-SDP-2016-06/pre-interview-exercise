import java.math.BigDecimal;
import java.util.List;

public class ShoppingCart {

    public BigDecimal Checkout(List<Fruit> items) {
        return items.stream()
                .map(Fruit::GetPrice)
                .reduce(new BigDecimal("0"), BigDecimal::add);
    }
}