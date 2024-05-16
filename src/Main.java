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

    public static void main(String[] args) throws Exception {
        // Create a Url object from the BASE_URL and API_KEY
        DataRead reader = new DataRead();
        HashMap<String, Double> currencyRates = reader.fetchData(BASE_URL, API_KEY);
        System.out.println(currencyRates);
    }
}
