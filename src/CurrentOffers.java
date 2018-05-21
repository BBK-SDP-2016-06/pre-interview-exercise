import java.math.BigDecimal;

public class CurrentOffers {

    public static Offer BuyOneGetOneFree(Fruit fruit) {
        return (items) -> {
            int offerItemsCount = (int)items.stream()
                    .filter(i -> i.getClass().equals(fruit.getClass()))
                    .count();
            int discountItemsCount = offerItemsCount / 2;
            return fruit.GetPrice().multiply(new BigDecimal(Integer.toString(discountItemsCount)));
        };
    }


}