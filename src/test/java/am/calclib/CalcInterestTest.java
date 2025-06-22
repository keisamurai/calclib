package am.calclib;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

public class CalcInterestTest {
    CalcInterest c = new CalcInterest();

    @Test
    public void calculateInterest_success() {
        BigDecimal rate = new BigDecimal("0.05");
        assertTrue(c.calculateInterest(rate, 10).compareTo(new BigDecimal("0.50")) == 0);
    }

    @Test
    public void calculateCompoundInterest_5p_10y() {
        BigDecimal rate = new BigDecimal("0.05");
        Integer term = 10;

        double result = c.calculateCompoundInterest(rate, term).setScale(3, BigDecimal.ROUND_UP).doubleValue();
        assertTrue(result == 0.629);
    }

    @Test
    public void calculateCompoundInterest_5p_20y() {
        BigDecimal rate = new BigDecimal("0.05");
        Integer term = 20;

        double result = c.calculateCompoundInterest(rate, term).setScale(3, BigDecimal.ROUND_UP).doubleValue();
        assertTrue(result == 1.654);
    }
}
