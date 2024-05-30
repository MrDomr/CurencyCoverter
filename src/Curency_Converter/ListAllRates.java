package Curency_Converter;

import java.util.HashMap;

public class ListAllRates {
    private final HashMap<String, Double> rates;

    public ListAllRates(HashMap<String, Double> rates, HashMap<String, String> names) {
        this.rates = rates;
    }

    public HashMap<String, Double> getAllRates(String origin) {
        HashMap<String, Double> result = new HashMap<>();

        if (!rates.containsKey(origin)) {
            throw new IllegalArgumentException("Origin currency code " + origin + " is not present in the currency rates.");
        }

        double originRate = rates.get(origin);

        for (String code : rates.keySet()) {

            double rate = rates.get(code) / originRate;

            result.put(code, rate); // Use the short form of the name because it does not match with the full name
        }
        return result;
    }
}

