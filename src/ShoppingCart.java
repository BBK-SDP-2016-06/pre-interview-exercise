import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ShoppingCart {

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

    public BigDecimal Checkout(String[] items, Offer... offers) {
        List<Fruit> fruitItems = Arrays.stream(items)
                .map(this::convertToFruit)
                .collect(Collectors.toList());
        return Checkout(fruitItems, offers);
    }

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