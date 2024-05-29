import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserNameApp {
    private String userName;

    public UserNameApp() {
        // Create the JFrame
        JFrame frame = new JFrame("Enter Your Name");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);

        // Create a panel to hold components
        JPanel panel = new JPanel();

        // Create a label, text field, and button
        JLabel label = new JLabel("What is your name?");
        JTextField textField = new JTextField(15);
        JButton button = new JButton("Submit");

        // Add components to the panel
        panel.add(label);
        panel.add(textField);
        panel.add(button);

        // Add panel to the frame
        frame.add(panel);

        // Add action listener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Set the userName
                setUserName(textField.getText());
                // Print the userName to the console (optional)
                System.out.println("User name is: " + getUserName());
                // Close the JFrame
                frame.dispose();
            }
        });

        // Make the JFrame visible
        frame.setVisible(true);
    }

    // Method to set the user name
    public void setUserName(String userName) {
        this.userName = userName;
    }

    // Method to get the user name
    public String getUserName() {
        return this.userName;
    }

    public static void main(String[] args) {
        // Run the GUI app in the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UserNameApp();
            }
        });
    }
}
