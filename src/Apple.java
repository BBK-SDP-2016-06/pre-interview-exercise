import java.math.BigDecimal;

public class Apple implements Fruit {

    @Override
    public BigDecimal GetPrice() {
        return new BigDecimal("0.60");
    }

}
