import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> currencyMap;

    public HashMap<String, String> getCurrencyMap() {
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader("JsonFiles/dict.json");
            currencyMap = gson.fromJson(reader, HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(currencyMap);
        /*
        for(String key : currencyMap.keySet()) {
            System.out.println(key + ": " + currencyMap.get(key));
        }

         */
        return currencyMap;
    }
}
