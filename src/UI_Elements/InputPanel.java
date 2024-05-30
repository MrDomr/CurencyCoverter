package UI_Elements;

import javax.swing.*;
import java.awt.*;

public class InputPanel extends JPanel {
    private final JTextField inputField;

    public InputPanel() {
        this.setLayout(null); // Disable layout manager

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(10, 10, 100, 30); // Set bounds for label

        inputField = new JTextField(10);
        inputField.setBounds(200, 10, 200, 30); // Set bounds (x, y, width, height)

        this.add(amountLabel);
        this.add(inputField);
        //this.setBackground(new Color(0x364f5a)); // Background for the panel
    }

    public double getAmount() {
        try {
            return Double.parseDouble(inputField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }
}