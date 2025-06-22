package am.calclib;

import java.util.List;


// 投資記録を表すレコードクラス
// 投資額と利益を保持
record InvestmentRecord(double amount, double profit){}

public class CalcInterest {

    // 単純収益率
    public double rateOfReturn(double initialInvestment, double finalValue) {
        return (finalValue - initialInvestment) / initialInvestment;
    }

    public double rateOfReturnWithProfit(double initialInvestment, double profit) {
        return profit / initialInvestment;
    }

    // 累積収益率
    public double cumulativeReturn(List<InvestmentRecord> records) {
        double cr = 1.0;
        for (InvestmentRecord record : records) {
            cr *= (1 + rateOfReturnWithProfit(record.amount(), record.profit()));
        }
        return cr;
    }

    // 時間加重平均収益率
    // Time Weighted Rate of Return (TWRR)
    // 収益の大きさを無視し、所与の投資金額に対する収益率を計算する
    public double timeWeightedRateOfReturn(List<InvestmentRecord> records) {
        return cumulativeReturn(records) - 1.0;
    }

    public double interest(double rate, Integer term) {
        return rate * term;
    }

    public double compoundInterest(double rate, Integer term) {
        return Math.pow(1.0 + rate, term) - 1.0;
    }

    public double genometricLinkRateOfReturn(List<Double> rates) {
        double product = 1.0;
        for (double rate : rates) {
            product *= (1.0 + rate);
        }

        return product - 1.0;
    }
}