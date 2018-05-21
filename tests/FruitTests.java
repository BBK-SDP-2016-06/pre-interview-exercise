import org.junit.Test;
import static org.junit.Assert.*;
import java.math.BigDecimal;

public class FruitTests {

    @Test
    public void testApplePrice() {
        Apple apple = new Apple();
        assertEquals(new BigDecimal("0.60"), apple.GetPrice());
    }

    @Test
    public void testOrangePrice() {
        Orange orange = new Orange();
        assertEquals(new BigDecimal("0.25"), orange.GetPrice());
    }
}