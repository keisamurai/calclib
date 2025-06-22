package am.calclib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.List;

public class CalcInterestTest {
    CalcInterest c = new CalcInterest();

    @Test
    public void calculateInterest_success() {
        double rate = 0.05;
        double expected = 0.50;
        double actual = c.interest(rate, 10);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void timeWeightedRateOfReturn_success() {
        List<InvestmentRecord> records = List.of(
            new InvestmentRecord(10.0, 0.0),
            new InvestmentRecord(10.0, 1.0),
            new InvestmentRecord(40.0, -4.0)
        );

        double expected = -0.01;
        double actual = c.timeWeightedRateOfReturn(records);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void calculateCompoundInterest_5p_10y() {
        double rate = 0.05;
        Integer term = 10;

        double compoundInterest = c.compoundInterest(rate, term);
        double expected = 0.6289;

        assertEquals(expected, compoundInterest, 0.0001);
    }

    @Test
    public void calculateCompoundInterest_5p_20y() {
        double rate = 0.05;
        Integer term = 20;

        double compoundInterest = c.compoundInterest(rate, term);
        double expected = 1.6533;

        assertEquals(expected, compoundInterest, 0.0001);
    }


    @Test
    public void genometricLinkRateOfReturn_success() {
        List<Double> rates = List.of(
            0.02,
            0.03
        );

        double expected = 0.0506;
        double actual = c.genometricLinkRateOfReturn(rates);

        assertEquals(expected, actual, 0.0001);
    }


    @Test
    public void genometricLinkRateOfReturn_minus_rates_success() {
        List<Double> rates = List.of(
            0.0126,
            -0.0207,
            0.0184
        );

        double expected = 0.0099;
        double actual = c.genometricLinkRateOfReturn(rates);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void genometricLinkRateOfReturn_emptyList() {
        List<Double> rates = List.of();

        double expected = 0.0;
        double actual = c.genometricLinkRateOfReturn(rates);

        assertEquals(expected, actual, 0.0001);
    }
}
