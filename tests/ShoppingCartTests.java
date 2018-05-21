import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartTests {

    @Test
    public void testEmptyShoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        List<Fruit> items = new ArrayList<>();
        assertEquals(new BigDecimal("0"), shoppingCart.Checkout(items));
    }

    @Test
    public void testShoppingCartWithItems() {
        ShoppingCart shoppingCart = new ShoppingCart();
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
        ShoppingCart shoppingCart = new ShoppingCart();
        List<Fruit> items = new ArrayList<>();
        items.add(new Apple());
        items.add(null);
        items.add(new Orange());
        assertEquals(new BigDecimal("0.85"), shoppingCart.Checkout(items));
    }

    @Test
    public void testShoppingCartWithStringItems() {
        ShoppingCart shoppingCart = new ShoppingCart();
        String[] items = new String[] {"Apple", "Apple", "Orange", "Apple"};
        assertEquals(new BigDecimal("2.05"), shoppingCart.Checkout(items));
    }

    @Test
    public void testShoppingCartWithStringItems2() {
        ShoppingCart shoppingCart = new ShoppingCart();
        String[] items = new String[] {"Apple", "Apple"};
        assertEquals(new BigDecimal("1.20"), shoppingCart.Checkout(items));
    }

    @Test
    public void testShoppingCartWithIncorrectStringName() {
        ShoppingCart shoppingCart = new ShoppingCart();
        String[] items = new String[] {"Apple", "Apple", "Plum"};
        assertEquals(new BigDecimal("1.20"), shoppingCart.Checkout(items));
    }

    @Test
    public void testShoppingCartWithLowerCaseName() {
        ShoppingCart shoppingCart = new ShoppingCart();
        String[] items = new String[] {"apple", "orange"};
        assertEquals(new BigDecimal("0.85"), shoppingCart.Checkout(items));
    }

    @Test
    public void testShoppingCartWithUpperCaseName() {
        ShoppingCart shoppingCart = new ShoppingCart();
        String[] items = new String[] {"APPLE", "ORANGE"};
        assertEquals(new BigDecimal("0.85"), shoppingCart.Checkout(items));
    }

    @Test
    public void testShoppingCartWithOffers() {
        ShoppingCart shoppingCart = new ShoppingCart();
        String[] items = new String[] {"Apple", "Orange", "Apple"};
        Offer[] offers = new Offer[] {
                CurrentOffers.BuyOneGetOneFree(new Apple()),
                CurrentOffers.ThreeForThePriceOfTwo(new Orange())
        };
        assertEquals(new BigDecimal("0.85"), shoppingCart.Checkout(items, offers));
    }

    @Test
    public void testShoppingCartWithOffers2() {
        ShoppingCart shoppingCart = new ShoppingCart();
        String[] items = new String[] {"Apple", "Orange", "Apple", "Orange", "Orange"};
        Offer[] offers = new Offer[] {
                CurrentOffers.BuyOneGetOneFree(new Apple()),
                CurrentOffers.ThreeForThePriceOfTwo(new Orange())
        };
        assertEquals(new BigDecimal("1.10"), shoppingCart.Checkout(items, offers));
    }

    @Test
    public void testShoppingCartWithOffers3() {
        ShoppingCart shoppingCart = new ShoppingCart();
        String[] items = new String[] {"Apple"};
        Offer[] offers = new Offer[] {
                CurrentOffers.BuyOneGetOneFree(new Apple()),
                CurrentOffers.ThreeForThePriceOfTwo(new Orange())
        };
        assertEquals(new BigDecimal("0.60"), shoppingCart.Checkout(items, offers));
    }

}