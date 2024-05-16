import java.util.HashMap;

public class RateCalculator {
    public double calculateRate(HashMap<String, Double> currencyRates, String originCurrency,
                                String targetCurrency, double amount){
        Double originRate = currencyRates.get(originCurrency);
        Double targetRate = currencyRates.get(targetCurrency);

        if (originRate == null) {
            throw new IllegalArgumentException("Origin currency " + originCurrency + " is not present in the currency rates.");
        }

        if (targetRate == null) {
            throw new IllegalArgumentException("Target currency " + targetCurrency + " is not present in the currency rates.");
        }

        return (amount * originRate) / targetRate;
    }
}
