package Curency_Converter;

import java.util.HashMap;

public class CurrencyConverter {
    private final DataRead reader;
    private final Dictionary dict;

    public CurrencyConverter(String baseUrl, String apiKey, String dictionaryPath) {
        this.reader = new DataRead(baseUrl, apiKey);
        this.dict = new Dictionary(dictionaryPath);
    }

    public HashMap<String, Double> getAllRates(String origin) throws Exception {
        HashMap<String, Double> currencyRates = reader.fetchData();

        ListAllRates listAllRates = new ListAllRates(currencyRates, dict.getCurrencyMap());

        return listAllRates.getAllRates(origin);
    }
}