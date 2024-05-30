package Curency_Converter;

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
    private final String BASE_URL;
    private final String API_KEY;

    public DataRead(String BASE_URL, String API_KEY) {
        this.BASE_URL = BASE_URL;
        this.API_KEY = API_KEY;
    }

    public HashMap<String, Double> fetchData() throws Exception {
        URL url = new URL(BASE_URL + "?apikey=" + API_KEY);

        // Create a connection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Get the response code
        int responseCode = connection.getResponseCode();

        // If the request was successful
        if(responseCode == 200) {

            // Create a BufferedReader to read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder responseContent = new StringBuilder();

            // Read the response
            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
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


            // Parse the JSON data to a HashMap and return it
            JsonObject jsonObject = gson.fromJson(jsonData, JsonObject.class);
            if (jsonObject.has("data")) {
                JsonObject dataObject = jsonObject.getAsJsonObject("data");
                return gson.fromJson(dataObject, type);
            } else {
                throw new Exception("Invalid response from API: " + jsonData);
            }

        } else {
            throw new Exception("Failed to fetch data: " + responseCode);
        }
    }
}