import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OfferTests {

    @Test
    public void testBuyOneGetOneFreeOfferOnTwoApples() {
        List<Fruit> items = new ArrayList<>();
        items.add(new Apple());
        items.add(new Apple());

        Offer buyOneGetOneFreeOnApples = CurrentOffers.BuyOneGetOneFree(new Apple());

        assertEquals(new BigDecimal("0.60"), buyOneGetOneFreeOnApples.GetPriceDiscount(items));
    }

    @Test
    public void testBuyOneGetOneFreeOfferOnThreeApples() {
        List<Fruit> items = new ArrayList<>();
        items.add(new Apple());
        items.add(new Apple());
        items.add(new Apple());
        Offer buyOneGetOneFreeOnApples = CurrentOffers.BuyOneGetOneFree(new Apple());

        assertEquals(new BigDecimal("0.60"), buyOneGetOneFreeOnApples.GetPriceDiscount(items));
    }

    @Test
    public void testBuyOneGetOneFreeOfferOnFourApples() {
        List<Fruit> items = new ArrayList<>();
        items.add(new Apple());
        items.add(new Apple());
        items.add(new Apple());
        items.add(new Apple());
        Offer buyOneGetOneFreeOnApples = CurrentOffers.BuyOneGetOneFree(new Apple());

        assertEquals(new BigDecimal("1.20"), buyOneGetOneFreeOnApples.GetPriceDiscount(items));
    }

    @Test
    public void testBuyOneGetOneFreeOfferOnEmpty() {
        List<Fruit> items = new ArrayList<>();
        Offer buyOneGetOneFreeOnApples = CurrentOffers.BuyOneGetOneFree(new Apple());
        assertEquals(new BigDecimal("0.00"), buyOneGetOneFreeOnApples.GetPriceDiscount(items));
    }

    @Test
    public void testBuyOneGetOneFreeOfferOnFourApplesAndOrange() {
        List<Fruit> items = new ArrayList<>();
        items.add(new Apple());
        items.add(new Apple());
        items.add(new Apple());
        items.add(new Apple());
        items.add(new Orange());
        Offer buyOneGetOneFreeOnApples = CurrentOffers.BuyOneGetOneFree(new Apple());

        assertEquals(new BigDecimal("1.20"), buyOneGetOneFreeOnApples.GetPriceDiscount(items));
    }

    @Test
    public void testThreeForThePriceOfTwoOnEmpty() {
        List<Fruit> items = new ArrayList<>();
        Offer threeForTwoOnOranges = CurrentOffers.ThreeForThePriceOfTwo(new Orange());

        assertEquals(new BigDecimal("0.00"), threeForTwoOnOranges.GetPriceDiscount(items));
    }

    @Test
    public void testThreeForThePriceOfTwoOnOneOrange() {
        List<Fruit> items = new ArrayList<>();
        items.add(new Orange());
        Offer threeForTwoOnOranges = CurrentOffers.ThreeForThePriceOfTwo(new Orange());
        assertEquals(new BigDecimal("0.00"), threeForTwoOnOranges.GetPriceDiscount(items));
    }

    @Test
    public void testThreeForThePriceOfTwoOnTwoOranges() {
        List<Fruit> items = new ArrayList<>();
        items.add(new Orange());
        items.add(new Orange());
        Offer threeForTwoOnOranges = CurrentOffers.ThreeForThePriceOfTwo(new Orange());
        assertEquals(new BigDecimal("0.00"), threeForTwoOnOranges.GetPriceDiscount(items));
    }

    @Test
    public void testThreeForThePriceOfTwoOnThreeOranges() {
        List<Fruit> items = new ArrayList<>();
        items.add(new Orange());
        items.add(new Orange());
        items.add(new Orange());
        Offer threeForTwoOnOranges = CurrentOffers.ThreeForThePriceOfTwo(new Orange());
        assertEquals(new BigDecimal("0.25"), threeForTwoOnOranges.GetPriceDiscount(items));
    }

    @Test
    public void testThreeForThePriceOfTwoOnSixOranges() {
        List<Fruit> items = new ArrayList<>();
        items.add(new Orange());
        items.add(new Orange());
        items.add(new Orange());
        items.add(new Orange());
        items.add(new Orange());
        items.add(new Orange());
        Offer threeForTwoOnOranges = CurrentOffers.ThreeForThePriceOfTwo(new Orange());
        assertEquals(new BigDecimal("0.50"), threeForTwoOnOranges.GetPriceDiscount(items));
    }
}
