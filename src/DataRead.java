import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.JsonObject;
import com.google.gson.Gson;
import java.util.HashMap;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class DataRead {
    private static final String API_KEY = "fca_live_m55KwmNC2VYX0dcfWM04hXGanbDzUe7mM9xyUd7b";
    private static final String BASE_URL = "https://api.freecurrencyapi.com/v1/latest";

    public HashMap<String, Double> fetchData() throws Exception {
        URL url = new URL(BASE_URL + "?apikey=" + API_KEY);

        // Create a connection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Get the response code
        int responseCode = connection.getResponseCode();

        // If the request was successful
        if(responseCode == 200){
            // Create a BufferedReader to read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuffer responseContent = new StringBuffer();

            // Read the response
            while((line = reader.readLine()) != null){
                responseContent.append(line);
                System.out.println(line);
            }

            // Close the reader and connection
            reader.close();
            connection.disconnect();

            // Parse the JSON response
            String jsonData = responseContent.toString();
            // Create a Gson object
            Gson gson = new Gson();

            // Define the type for the HashMap
            Type type = new TypeToken<HashMap<String, Double>>(){}.getType();

            // Parse the JSON data to a HashMap
            HashMap<String, Double> data = gson.fromJson(gson.fromJson(jsonData, JsonObject.class).getAsJsonObject("data"), type);

            // Print the HashMap
            for(String key : data.keySet()) {
                System.out.println(key + ": " + data.get(key));
            }
            return data;
        }
        else{
            return null;
        }
    }
}
