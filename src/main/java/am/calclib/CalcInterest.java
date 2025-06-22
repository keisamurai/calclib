package am.calclib;

import java.math.BigDecimal;

import static am.calclib.CommonUtils.checkInput;
import static am.calclib.CommonConfigs.*;

public class CalcInterest {

    public BigDecimal calculateRateOfReturn(BigDecimal initialInvestment, BigDecimal finalValue) {
        checkInput(initialInvestment, finalValue);
        return finalValue.subtract(initialInvestment)
                .divide(initialInvestment, DEFAULT_SCALE, ROUNDING_MODE);
    }

    public BigDecimal calculateInterest(BigDecimal rate, Integer term) {
        checkInput(rate, term);
        return rate.multiply(BigDecimal.valueOf(term));
    }

    public BigDecimal calculateCompoundInterest(BigDecimal rate, Integer term) {
        checkInput(rate, term);
        return BigDecimal.ONE.add(rate).pow(term).subtract(BigDecimal.ONE);
    }

}