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
