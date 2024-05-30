package Curency_Converter;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Dictionary {
    private final HashMap<String, String> currencyMap;

    public Dictionary(String filePath) {
        this.currencyMap = loadCurrencyMap(filePath);
    }

    private HashMap<String, String> loadCurrencyMap(String filePath) {
        HashMap<String, String> map = new HashMap<>();

        Gson gson = new Gson();

        try {

            FileReader reader = new FileReader(filePath);
            map = gson.fromJson(reader, HashMap.class);
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public String[] getCurrencyCodes() {
        return currencyMap.values().toArray(new String[0]);
    }

    public HashMap<String, String> getCurrencyMap() {
        return currencyMap;
    }
}
