package tests;

import org.junit.Test;
import static org.junit.Assert.*;
import java.math.BigDecimal;


public class FruitTests {

    @Test
    public void testApplePrice() {
        Apple apple = new Apple();
        assertEquals(apple.GetPrice(), new BigDecimal("0.60"));
    }
}