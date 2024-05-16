import java.util.HashMap;

public class CurrencyConverter {
    private DataRead reader;
    private Dictionary dict;
    private ListAllRates listAllRates;

    public CurrencyConverter(String baseUrl, String apiKey, String dictionaryPath) {
        this.reader = new DataRead(baseUrl, apiKey);
        this.dict = new Dictionary(dictionaryPath);
    }

    public HashMap<String, Double> getAllRates(String origin) throws Exception {
        HashMap<String, Double> currencyRates = reader.fetchData();
        listAllRates = new ListAllRates(currencyRates, dict.getCurrencyMap());
        System.out.println(currencyRates);

        return listAllRates.getAllRates(origin);
    }
}
