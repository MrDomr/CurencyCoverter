package UI_Elements;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {
    private final JButton button;

    public ButtonPanel() {
        this.setLayout(null); // Disable layout manager

        button = new JButton("Convert");
        this.setLayout(null); // Disable layout manager
        button.setBounds(0, 0, 100, 40); // Set bounds (x, y, width, height)

        this.add(button);
        this.setBackground(new Color(0x364f5a)); // Background for the panel
    }

    public JButton getButton() {
        return button;
    }
}