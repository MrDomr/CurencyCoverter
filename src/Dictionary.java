import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> currencyMap;
    private String filePath;

    public Dictionary(String filePath) {
        this.filePath = filePath;
        this.currencyMap = loadCurrencyMap();
    }

    private HashMap<String, String> loadCurrencyMap() {
        HashMap<String, String> map = new HashMap<>();
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader(filePath);
            map = gson.fromJson(reader, HashMap.class);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(currencyMap);
        /*
        for(String key : currencyMap.keySet()) {
            System.out.println(key + ": " + currencyMap.get(key));
        }

         */
        return map;
    }

    public HashMap<String, String> getCurrencyMap() {
        return this.currencyMap;
    }
}
