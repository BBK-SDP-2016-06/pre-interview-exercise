import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * A shopping cart with methods used to calculate the price of item lists.
 */
public class ShoppingCart {

    /**
     * Calculates the total price of a list of items.
     * @param items The fruit items to be purchased.
     * @param offers An optional list of offers to apply to the shopping cart.
     * @return Total price of items.
     */
    public BigDecimal Checkout(List<Fruit> items, Offer... offers) {
        if (items == null) {
            return new BigDecimal("0");
        }
        else {
            BigDecimal basePrice = items.stream()
                    .filter(Objects::nonNull)
                    .map(Fruit::GetPrice)
                    .reduce(new BigDecimal("0"), BigDecimal::add);

            for (Offer offer: offers) {
                basePrice = basePrice.subtract(offer.GetPriceDiscount(items));
            }
            return basePrice;
        }
    }

    /**
     * Override method to the aforementioned to increase the flexibility
     * of calling 'Checkout'.
     * @param items The fruit items to be purchased.
     * @param offers An optional list of offers to apply to the shopping cart.
     * @return Total price of items.
     */
    public BigDecimal Checkout(String[] items, Offer... offers) {
        List<Fruit> fruitItems = Arrays.stream(items)
                .map(this::convertToFruit)
                .collect(Collectors.toList());
        return Checkout(fruitItems, offers);
    }

    /**
     * Uses java reflection to convert the string fruit names into fruit objects.
     * @param item The name of the fruit.
     * @return The object that the item name represents.
     */
    private Fruit convertToFruit(String item) {
        try {
            String name = item.substring(0, 1).toUpperCase() + item.substring(1).toLowerCase();
            Class<?> c = Class.forName(name);
            Constructor<?> ctor = c.getConstructor();
            Object o = ctor.newInstance();
            return (Fruit)o;
        } catch (IndexOutOfBoundsException | ClassNotFoundException |
                NoSuchMethodException | IllegalAccessException |
                InvocationTargetException | InstantiationException e) {
            return null;
        }
    }
}