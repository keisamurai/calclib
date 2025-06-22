package am.calclib;

import static am.calclib.CommonConfigs.DEFAULT_SCALE;
import static am.calclib.CommonConfigs.ROUNDING_MODE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.List;

public class CalcInterestTest {
    CalcInterest c = new CalcInterest();

    @Test
    public void calculateInterest_success() {
        BigDecimal rate = new BigDecimal("0.05");
        BigDecimal expected = new BigDecimal("0.50");
        BigDecimal actual = c.calculateInterest(rate, 10);

        assertEquals(expected, actual);
    }

    @Test
    public void calculateCompoundInterest_5p_10y() {
        BigDecimal rate = new BigDecimal("0.05");
        Integer term = 10;

        BigDecimal compoundInterest = c.calculateCompoundInterest(rate, term);
        BigDecimal rounded = compoundInterest.setScale(DEFAULT_SCALE, ROUNDING_MODE);
        double expected = 0.6289;
        double actual = rounded.doubleValue();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateCompoundInterest_5p_20y() {
        BigDecimal rate = new BigDecimal("0.05");
        Integer term = 20;

        BigDecimal compoundInterest = c.calculateCompoundInterest(rate, term);
        BigDecimal rounded = compoundInterest.setScale(DEFAULT_SCALE, ROUNDING_MODE);
        double expected = 1.6533;
        double actual = rounded.doubleValue();

        assertEquals(expected, actual);
    }

    @Test
    public void genometricLinkRateOfReturn_success() {
        List<BigDecimal> rates = List.of(
            new BigDecimal("0.05"),
            new BigDecimal("0.10"),
            new BigDecimal("0.15")
        );

        BigDecimal expected = new BigDecimal("0.3282").setScale(DEFAULT_SCALE, ROUNDING_MODE);
        BigDecimal actual = c.genometricLinkRateOfReturn(rates);

        assertEquals(expected, actual);
    }
}
