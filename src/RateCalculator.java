import java.util.HashMap;

public class RateCalculator {
    public double calculateRate(HashMap<String, Double> currencyRates, String originCurrency,
                             String targetCurrency, double amount){
        return (amount * currencyRates.get(originCurrency))/ currencyRates.get(targetCurrency);
    }
}
