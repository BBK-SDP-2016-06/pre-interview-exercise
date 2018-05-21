import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class ShoppingCart {

    public BigDecimal Checkout(List<Fruit> items) {
        if (items == null) {
            return new BigDecimal("0");
        }
        else {
            return items.stream()
                    .filter(Objects::nonNull)
                    .map(Fruit::GetPrice)
                    .reduce(new BigDecimal("0"), BigDecimal::add);
        }
    }
}