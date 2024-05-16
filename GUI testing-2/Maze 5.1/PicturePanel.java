import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PicturePanel extends JPanel {
    private ImageIcon[] images;
    private int currentIndex;

    public PicturePanel() {
        // Initialize the array of images
        images = new ImageIcon[3];
        images[0] = new ImageIcon("blue room.png"); // Path to your image files
        images[1] = new ImageIcon("pink room.png");
        images[2] = new ImageIcon("green room.png");

        // Set initial image
        currentIndex = 0;

        // Set up the panel
        setPreferredSize(new Dimension(400, 300)); // Adjust dimensions as needed
        setBackground(Color.WHITE);
        
        // Add a button to change the picture
        JButton changeButton = new JButton("Change Picture");
        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentIndex = (currentIndex + 1) % images.length;
                repaint();
            }
        });
        add(changeButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (images[currentIndex] != null) {
            // Draw the current image
            g.drawImage(images[currentIndex].getImage(), 0, 0, getWidth(), getHeight(), this);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Picture Panel");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new PicturePanel());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
