import java.math.BigDecimal;

/**
 * Utility class for encapsulating current offers that can be used by the shopping
 * cart's checkout methods. Note that code duplication occurs here. Needs to be
 * refactored.
 */
public class CurrentOffers {

    /**
     * Represents a buy one get one free offer.
     * @param fruit The fruit type that this offer applies to.
     * @return An offer function that calculates the discount to be subtracted from
     * the final cart price given a list of items.
     */
    public static Offer BuyOneGetOneFree(Fruit fruit) {
        return (items) -> {
            int offerItemsCount = (int)items.stream()
                    .filter(i -> i.getClass().equals(fruit.getClass()))
                    .count();
            int discountItemsCount = offerItemsCount / 2;
            return fruit.GetPrice().multiply(new BigDecimal(Integer.toString(discountItemsCount)));
        };
    }

    /**
     * Represents a three for the price of two offer.
     * @param fruit The fruit type that this offer applies to.
     * @return An offer function that calculates the discount to be subtracted from
     * the final cart price given a list of items.
     */
    public static Offer ThreeForThePriceOfTwo(Fruit fruit) {
        return (items) -> {
            int offerItemsCount = (int)items.stream()
                    .filter(i -> i.getClass().equals(fruit.getClass()))
                    .count();
            int discountItemsCount = offerItemsCount / 3;
            return fruit.GetPrice().multiply(new BigDecimal(Integer.toString(discountItemsCount)));
        };
    }
}