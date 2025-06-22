package am.calclib;

import java.math.BigDecimal;

import static am.calclib.CommonUtils.checkInput;

public class CalcInterest {

    public BigDecimal calclateRateOfReturn(BigDecimal initialInvestment, BigDecimal finalValue) {
        checkInput(initialInvestment, finalValue);

        BigDecimal rateOfReturn = finalValue.subtract(initialInvestment)
                .divide(initialInvestment, BigDecimal.ROUND_HALF_UP);
        return rateOfReturn;
    }

    public BigDecimal calculateInterest(BigDecimal rate, Integer term) {
        checkInput(rate, term);

        BigDecimal interest = rate.multiply(BigDecimal.valueOf(term));
        return interest;
    }

    public BigDecimal calculateCompoundInterest(BigDecimal rate, Integer term) {
        checkInput(rate, term);

        BigDecimal compoundInterest = BigDecimal.ONE.add(rate).pow(term).subtract(BigDecimal.ONE);
        return compoundInterest;
    }

}