import java.math.BigDecimal;

public class Orange implements Fruit {

    @Override
    public BigDecimal GetPrice() {
        return new BigDecimal("0.25");
    }
}