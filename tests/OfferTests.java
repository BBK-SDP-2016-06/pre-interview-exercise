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
        assertEquals(new BigDecimal("0.60"), CurrentOffers.BuyOneGetOneFree("Apple", items));
    }

}
