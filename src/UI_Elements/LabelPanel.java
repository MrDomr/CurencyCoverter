package UI_Elements;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class LabelPanel extends JPanel {

    public LabelPanel() {
        ImageIcon imageLabel = new ImageIcon(""); // Link for label image
        Border border = BorderFactory.createLineBorder(new Color(0x009f00), 3); // Border size, will contain the color of label

        JLabel label = new JLabel();
        label.setHorizontalTextPosition(JLabel.CENTER); // Set text LEFT, CENTER, RIGHT of image
        label.setVerticalTextPosition(JLabel.TOP); // Set text TOP, CENTRE, BOTTOM of image
        label.setForeground(new Color(0x00aa00)); // Color
        label.setFont(new Font("MV Boli", Font.PLAIN, 20)); // Font
        label.setIconTextGap(10); // Distance of the text to the image
        label.setBackground(Color.black); // Set background to color
        label.setOpaque(true); // Display the background
        label.setBorder(border); // Set the border of the label
        label.setVerticalAlignment(JLabel.CENTER); // Set the vertical position for the label
        label.setHorizontalAlignment(JLabel.CENTER); // Set the horizontal position for the label

        label.setText("Currency converter");
        label.setIcon(imageLabel);

        // Use a BorderLayout for automatic centering
        this.setLayout(new BorderLayout());
        this.add(label, BorderLayout.CENTER); // Add the label to the center of the panel
    }
}
