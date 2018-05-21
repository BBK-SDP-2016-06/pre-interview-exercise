import java.math.BigDecimal;
import java.util.List;

@FunctionalInterface
public interface Offer {
    BigDecimal GetPriceDiscount(List<Fruit> items);
}