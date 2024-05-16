import java.util.HashMap;

public class ListAllRates {
    public HashMap<String, Double> getAllRates(HashMap<String, Double> rates, HashMap<String, String> names, String origin) {
        HashMap<String, Double> result = new HashMap<>();
        double originRate = rates.get(origin);

        for (String code : rates.keySet()) {
            String fullName = getFullName(names, code);
            double rate = rates.get(code) / originRate;
            result.put(fullName, rate);
        }

        return result;
    }

    private String getFullName(HashMap<String, String> names, String code) {
        for (String name : names.keySet()) {
            if (names.get(name).equals(code)) {
                return name;
            }
        }

        return null;
    }
}

