package UI_Elements;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class CurrencyListPanel extends JPanel {
    public CurrencyListPanel(HashMap<String, String> currencyMap, HashMap<String, Double> exchangeRates) {
        this.setLayout(new BorderLayout()); // Use BorderLayout for this panel

        DefaultListModel<String> listModel = new DefaultListModel<>();

        for (String fullName : currencyMap.keySet()) {
            String shortName = currencyMap.get(fullName);
            double rate = exchangeRates.getOrDefault(shortName, 0.0);
            listModel.addElement(fullName + " (" + shortName + "):  " + round(rate, 2));
        }

        JList<String> currencyList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(currencyList);


        JLabel title = new JLabel("Currency List with Exchange Rates (USD base)");
        title.setHorizontalAlignment(JLabel.CENTER);


        currencyList.setBackground(new Color(0x364f5a));
        currencyList.setForeground(Color.WHITE);

        this.add(title, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}