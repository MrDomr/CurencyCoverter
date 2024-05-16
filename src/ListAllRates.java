import java.util.HashMap;

public class ListAllRates {
    private HashMap<String, Double> rates;
    private HashMap<String, String> names;

    public ListAllRates(HashMap<String, Double> rates, HashMap<String, String> names) {
        this.rates = rates;
        this.names = names;
    }

    public HashMap<String, Double> getAllRates(String origin) {
        HashMap<String, Double> result = new HashMap<>();
        double originRate = rates.get(origin);

        for (String code : rates.keySet()) {
            String fullName = getFullName(code);
            double rate = rates.get(code) / originRate;
            result.put(fullName, rate);
        }

        return result;
    }

    private String getFullName(String code) {
        for (String name : names.keySet()) {
            if (names.get(name).equals(code)) {
                return name;
            }
        }

        return null;
    }
}

