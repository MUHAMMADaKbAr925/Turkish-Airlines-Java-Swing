import java.awt.*;
import javax.swing.*;

public class FirstPanelMain extends JPanel {
    
    private Image backgroundimage;

    public FirstPanelMain() {
        setPreferredSize(new Dimension(400, 400)); // Set preferred size for the panel
        loadImage(); // Load the image
    }

    private void loadImage() {
        ImageIcon icon = new ImageIcon("istanbulview.jpg");
        if (icon != null && icon.getImage() != null) {         
             backgroundimage = icon.getImage();
        } else {
            System.out.println("Failed to load the image.");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundimage != null) {
            // Scale the image to cover the entire panel
            g.drawImage(backgroundimage, 0, 0, getWidth(), getHeight(), this);
        }
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 24));

        String line1 = "Hello";
        int line1Height = g.getFontMetrics().getHeight();
        int line1X = 10;
        int line1Y = (getHeight() - line1Height * 2) / 2;
        g.drawString(line1, line1X, line1Y);

        String line2 = "Where do you want to explore";
        int line2Height = g.getFontMetrics().getHeight();
        int line2X = 10;
        int line2Y = line1Y + line1Height + 10;
        g.drawString(line2, line2X, line2Y);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Image Panel");
        FirstPanelMain panel = new FirstPanelMain();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Terminate the application when the window is closed
        frame.getContentPane().add(panel);
        frame.pack(); // Automatically resize the frame to fit the panel
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }
}
