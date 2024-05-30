import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.JsonObject;
import com.google.gson.Gson;
import java.util.HashMap;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class Main {
    private static final String API_KEY = "fca_live_m55KwmNC2VYX0dcfWM04hXGanbDzUe7mM9xyUd7b";
    private static final String BASE_URL = "https://api.freecurrencyapi.com/v1/latest";
    private static final String DICTIONARY_PATH = "JsonFiles/dict.json";

    public static void main(String[] args) throws Exception {

        DataRead reader = new DataRead(BASE_URL, API_KEY);

        HashMap<String, Double> currencyRates = reader.fetchData();

        //System.out.println(currencyRates);


        Dictionary dict = new Dictionary(DICTIONARY_PATH);

        RateCalculator rateCalculator = new RateCalculator();
        //rateCalculator.calculateRate(currencyRates, "BGN", "NOK", 100);
        //System.out.println(rateCalculator.calculateRate(currencyRates, "BGN", "NOK", 100));

        ListAllRates temp = new ListAllRates(currencyRates, dict.getCurrencyMap());
        HashMap<String, Double> allRates = temp.getAllRates("USD");

        for(String key : allRates.keySet()) {

            System.out.println(key + ": " + allRates.get(key));

        }

    }

}