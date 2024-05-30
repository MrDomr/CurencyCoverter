package Curency_Converter;

import java.util.HashMap;

public class ConversionLogic {
    private final CurrencyConverter converter;

    public ConversionLogic(String baseUrl, String apiKey, String dictionaryPath) {
        this.converter = new CurrencyConverter(baseUrl, apiKey, dictionaryPath);
    }

    public double convert(String fromCurrency, String toCurrency, double amount) throws Exception {
        HashMap<String, Double> rates = converter.getAllRates(fromCurrency);

        if (!rates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Currency code " + toCurrency + " is not available in the rates.");
        }

        double rate = rates.get(toCurrency);
        return round (amount * rate, 2);
    }

    public CurrencyConverter getConverter() {
        return converter;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}