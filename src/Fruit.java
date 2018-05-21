import java.math.BigDecimal;

/**
 * Interface for representing all fruit within the model. Each fruit
 * contains a single price property which is read-only.
 */
public interface Fruit {

    BigDecimal GetPrice();
}
