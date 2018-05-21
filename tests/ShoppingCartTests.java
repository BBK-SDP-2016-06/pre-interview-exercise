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
}
