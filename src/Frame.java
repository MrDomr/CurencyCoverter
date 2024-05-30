<<<<<<< HEAD
import Curency_Converter.ConversionLogic;
import Curency_Converter.Dictionary;
import UI_Elements.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Frame extends JFrame {
    private final ComboBoxPanel comboBoxPanel;
    private final InputPanel inputPanel;
    private final OutputPanel outputPanel;
    private final ConversionLogic conversionLogic;
    private final CurrencyListPanel currencyListPanel;

    public Frame() {
        // Initialize components
        Dictionary currencyDictionary = new Dictionary("JsonFiles/dict.json");

        String[] currencyOptions = currencyDictionary.getCurrencyCodes(); // Gets the options for the currencies
        HashMap<String, String> currencyMap = currencyDictionary.getCurrencyMap();

        comboBoxPanel = new ComboBoxPanel(currencyOptions);
        inputPanel = new InputPanel();
        outputPanel = new OutputPanel();

        // Initialize conversion logic
        conversionLogic = new ConversionLogic("https://api.freecurrencyapi.com/v1/latest", "fca_live_m55KwmNC2VYX0dcfWM04hXGanbDzUe7mM9xyUd7b", "JsonFiles/dict.json");

        // Fetch exchange rates for display
        HashMap<String, Double> exchangeRates = new HashMap<>();
        try {
            exchangeRates = conversionLogic.getConverter().getAllRates("USD"); // Assuming USD as the base currency
        } catch (Exception e) {
            e.printStackTrace();
        }

        currencyListPanel = new CurrencyListPanel(currencyMap, exchangeRates);

        // Local variables because java suggested to do this
        ButtonPanel buttonPanel = new ButtonPanel();
        LabelPanel labelPanel = new LabelPanel();

        // Frame Customization
        this.setTitle("Currency Conversion");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(800, 625); // Increased size to accommodate currency list
        this.setLayout(null); // Disable layout manager for absolute positioning
        this.getContentPane().setBackground(new Color(0x364f5a));
        this.setIconImage(new ImageIcon("").getImage()); // Could add an icon to the top left corner of the window

        // Set bounds for each panel manually
        int objX = 50;
        int objY = 70;
        int objWidth = 675; // Increased width for currency list panel
        int objHeight = 50;

        int buttonWidth = 100;
        int buttonHeight = 40;

        labelPanel.setBounds(objX, 0, objWidth, objHeight);
        comboBoxPanel.setBounds(objX, objY, objWidth, objHeight);
        inputPanel.setBounds(objX, objY * 2, objWidth, objHeight);
        buttonPanel.setBounds(objX * 6, objY * 3, buttonWidth, buttonHeight);
        outputPanel.setBounds(objX, objY * 4 - (objHeight - buttonHeight), objWidth, objHeight);
        currencyListPanel.setBounds(objX, objY * 5, objWidth, 200); // Added currency list panel

        // Add components to the frame
        this.add(labelPanel);
        this.add(comboBoxPanel);
        this.add(inputPanel);
        this.add(outputPanel);
        this.add(buttonPanel);
        this.add(currencyListPanel); // Added currency list panel

        // Add button action listener
        buttonPanel.getButton().addActionListener(e -> {
            try {
                String fromCurrency = comboBoxPanel.getFromCurrency();
                String toCurrency = comboBoxPanel.getToCurrency();
                double amount = inputPanel.getAmount();
                double result = conversionLogic.convert(fromCurrency, toCurrency, amount);
                outputPanel.setResult(result);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(Frame.this, "Error: " + ex.getMessage(), "Conversion Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(Frame.this, "Error: " + ex.getMessage(), "Conversion Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        this.setVisible(true);
    }
}
=======
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Frame extends JFrame {

    Frame() {

        /// Contents of the window
        ImageIcon imageLabel = new ImageIcon(""); // Link for label image
        Border border = BorderFactory.createLineBorder(Color.green, 3); // Border size, will contain the colour of label

        JLabel label = new JLabel();
        label.setHorizontalTextPosition(JLabel.CENTER); // Set text LEFT, CENTER, RIGHT of image
        label.setVerticalTextPosition(JLabel.TOP); // Set text TOP, CENTRE, BOTTOM of image
        label.setForeground(new Color(0x00FF00)); // Colour
        label.setFont(new Font("MV Boli", Font.PLAIN, 20)); // Font
        label.setIconTextGap(10); // Distance of the text to the image
        label.setBackground(Color.black); // Set background to colour
        label.setOpaque(true); // Display the background
        label.setBorder(border); // Set the border of the label
        label.setVerticalAlignment(JLabel.CENTER); // Set the vertical possition for tha label
        label.setHorizontalAlignment(JLabel.CENTER); // Set the horizontal possition for the label

        // Customize the layout
        label.setBounds(0, 0, 250, 250);

        label.setText("Currency conversion");
        label.setIcon(imageLabel);
        this.add(label); // Add the label to the frame

        /// General settings

        //JFrame frame = new JFrame(); // Frame

        this.setTitle("Currency conversion");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(400, 400);
        this.setVisible(true);

        ImageIcon image = new ImageIcon(""); // Give directory where logo is stored.
        this.setIconImage(image.getImage()); // Changes icon of the this.
        this.getContentPane().setBackground(new Color(0x364f5a));

        this.setLayout(null); // Remove the default layout


    }

}
>>>>>>> origin/master
