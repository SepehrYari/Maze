import java.awt.*;
import javax.swing.*;
/**
 * DialogPanel Class is designed to be the text area for all game diaolog to occur on
 *
 * @author Sepehr Arya Yari
 * @version Spring 2024
 */
public class DialogPanel extends JPanel {
    private String initialString = "You stand alone in an unfamiliar room. What will you do?";
    private JTextArea textArea;

    /**
 * Constructor with no perameters
 *
 */
    public DialogPanel() {
        // Set layout manager to GridBagLayout
        setLayout(new GridBagLayout());

        // Create GridBagConstraints for components
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add padding

        // Create the text area
        textArea = new JTextArea(initialString, 5, 20);
        textArea.setEditable(false); // Make it read-only
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setForeground(Color.GREEN); // Set text color to bright green
        textArea.setBackground(Color.BLACK); // Set background color to black
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH; // Fill both horizontally and vertically
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(new JScrollPane(textArea), gbc);
    }
    
 /**
   * Method to set text in JTextAreas
   * 
   * @param String newText to set the dialog box's text
   */
public void setText(String newText) {
        textArea.setText(newText);
}


/**
   * Method to get text in JTextAreas
   * 
   */
public String getText(){
        return textArea.getText();
}
}
