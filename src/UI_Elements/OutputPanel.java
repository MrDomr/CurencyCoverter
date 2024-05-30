package UI_Elements;

import javax.swing.*;
import java.awt.*;

public class OutputPanel extends JPanel {
    private final JTextField outputField;

    public OutputPanel() {
        this.setLayout(null); // Disable layout manager

        JLabel resultLabel = new JLabel("Converted Amount:");
        resultLabel.setBounds(10, 10, 130, 30); // Set bounds for label

        outputField = new JTextField(10);
        outputField.setBounds(200, 10, 200, 30); // Set bounds (x, y, width, height)
        outputField.setEditable(false); // Make output field read-only

        this.add(resultLabel);
        this.add(outputField);
        //this.setBackground(new Color(0x364f5a)); // Background for the panel
    }

    public void setResult(double result) {
        outputField.setText(String.format("%.2f", result));
    }
}