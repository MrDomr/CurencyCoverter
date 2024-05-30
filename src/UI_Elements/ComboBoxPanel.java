package UI_Elements;

import javax.swing.*;

public class ComboBoxPanel extends JPanel {
    private final JComboBox<String> fromCurrency;
    private final JComboBox<String> toCurrency;

    public ComboBoxPanel(String[] currencyOptions) {

        this.setLayout(null); // Disable layout manager


        // Convert from the currency
        JLabel fromLabel = new JLabel("From:");
        fromLabel.setBounds(10, 10, 50, 30);

        fromCurrency = new JComboBox<>(currencyOptions);
        fromCurrency.setBounds(70, 10, 200, 30);


        // Convert To the currency
        JLabel toLabel = new JLabel("To:");
        toLabel.setBounds(300, 10, 50, 30);

        toCurrency = new JComboBox<>(currencyOptions);
        toCurrency.setBounds(350, 10, 200, 30);


        this.add(fromLabel);
        this.add(fromCurrency);
        this.add(toLabel);
        this.add(toCurrency);
    }

    public String getFromCurrency() {

        return (String) fromCurrency.getSelectedItem();
    }

    public String getToCurrency() {

        return (String) toCurrency.getSelectedItem();
    }
}