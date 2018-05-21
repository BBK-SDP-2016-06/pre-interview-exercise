import java.math.BigDecimal;
import java.util.List;

/**
 * Functional interface that represents an offer.
 */
@FunctionalInterface
public interface Offer {
    /**
     * Obtains the discount price to be deducted from the final base
     * price of the cart.
     * @param items A list of cart items that this offer will be applied to.
     * @return The discount price.
     */
    BigDecimal GetPriceDiscount(List<Fruit> items);
}