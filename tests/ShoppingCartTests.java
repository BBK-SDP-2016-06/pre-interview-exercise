import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartTests {

    private ShoppingCart shoppingCart;

    @Before
    public void init() {
        this.shoppingCart = new ShoppingCart();
    }

    @Test
    public void testEmptyShoppingCart() {
        List<Fruit> items = new ArrayList<>();
        assertEquals(new BigDecimal("0"), shoppingCart.Checkout(items));
    }

    @Test
    public void testShoppingCartWithItems() {
        List<Fruit> items = new ArrayList<>();
        items.add(new Apple());
        items.add(new Apple());
        items.add(new Orange());
        items.add(new Apple());
        assertEquals(new BigDecimal("2.05"), shoppingCart.Checkout(items));
    }
/*
    @Test
    public void testShoppingCartWithNullItems() {
        ShoppingCart shoppingCart = new ShoppingCart();
        assertEquals(new BigDecimal("0"), shoppingCart.Checkout(null));
    }
    */

    @Test
    public void testShoppingCartWithSomeNullItems() {
        List<Fruit> items = new ArrayList<>();
        items.add(new Apple());
        items.add(null);
        items.add(new Orange());
        assertEquals(new BigDecimal("0.85"), shoppingCart.Checkout(items));
    }

    @Test
    public void testShoppingCartWithStringItems() {
        String[] items = new String[] {"Apple", "Apple", "Orange", "Apple"};
        assertEquals(new BigDecimal("2.05"), shoppingCart.Checkout(items));
    }

    @Test
    public void testShoppingCartWithStringItems2() {
        String[] items = new String[] {"Apple", "Apple"};
        assertEquals(new BigDecimal("1.20"), shoppingCart.Checkout(items));
    }

    @Test
    public void testShoppingCartWithIncorrectStringName() {
        String[] items = new String[] {"Apple", "Apple", "Plum"};
        assertEquals(new BigDecimal("1.20"), shoppingCart.Checkout(items));
    }

    @Test
    public void testShoppingCartWithLowerCaseName() {
        String[] items = new String[] {"apple", "orange"};
        assertEquals(new BigDecimal("0.85"), shoppingCart.Checkout(items));
    }

    @Test
    public void testShoppingCartWithUpperCaseName() {
        String[] items = new String[] {"APPLE", "ORANGE"};
        assertEquals(new BigDecimal("0.85"), shoppingCart.Checkout(items));
    }

    @Test
    public void testShoppingCartWithOffers() {
        String[] items = new String[] {"Apple", "Orange", "Apple"};
        Offer[] offers = new Offer[] {
                CurrentOffers.BuyOneGetOneFree(new Apple()),
                CurrentOffers.ThreeForThePriceOfTwo(new Orange())
        };
        assertEquals(new BigDecimal("0.85"), shoppingCart.Checkout(items, offers));
    }

    @Test
    public void testShoppingCartWithOffers2() {
        String[] items = new String[] {"Apple", "Orange", "Apple", "Orange", "Orange"};
        Offer[] offers = new Offer[] {
                CurrentOffers.BuyOneGetOneFree(new Apple()),
                CurrentOffers.ThreeForThePriceOfTwo(new Orange())
        };
        assertEquals(new BigDecimal("1.10"), shoppingCart.Checkout(items, offers));
    }

    @Test
    public void testShoppingCartWithOffers3() {
        String[] items = new String[] {"Apple"};
        Offer[] offers = new Offer[] {
                CurrentOffers.BuyOneGetOneFree(new Apple()),
                CurrentOffers.ThreeForThePriceOfTwo(new Orange())
        };
        assertEquals(new BigDecimal("0.60"), shoppingCart.Checkout(items, offers));
    }

    @Test
    public void testShoppingCartWithOffers4() {
        String[] items = new String[] {"Apple", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange"};
        Offer[] offers = new Offer[] {
                CurrentOffers.BuyOneGetOneFree(new Apple()),
                CurrentOffers.ThreeForThePriceOfTwo(new Orange())
        };
        assertEquals(new BigDecimal("2.20"), shoppingCart.Checkout(items, offers));
    }

    @Test
    public void testShoppingCartWithOffers5() {
        String[] items = new String[] {};
        Offer[] offers = new Offer[] {
                CurrentOffers.BuyOneGetOneFree(new Apple()),
                CurrentOffers.ThreeForThePriceOfTwo(new Orange())
        };
        assertEquals(new BigDecimal("0.00"), shoppingCart.Checkout(items, offers));
    }
}