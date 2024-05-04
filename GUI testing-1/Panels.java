
/**
 * Write a description of class Panels here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.BorderFactory; 
import javax.swing.JPanel;

public class Panels extends JFrame
{
    public Panels()
    {
        JLabel label = new JLabel(); // creates label which is a GUI display area for a string of text, an image, or even both

        ImageIcon image = new ImageIcon("LOGO.png"); //crates an image icon we can use
        ImageIcon picture = new ImageIcon("picture.png");
        Border border = BorderFactory.createLineBorder(new Color(10,10,10),5); //creates a Border for to pair to a label or other object
        
        label.setText("Hello!");
        label.setIcon(picture); // adds a imageicon onto the label/frame
        label.setVerticalAlignment(JLabel.BOTTOM);
        label.setHorizontalAlignment(JLabel.RIGHT);
        
        JPanel redPanel = new JPanel(); //creates the panel we can modify
        redPanel.setBackground(Color.red); //sets the background color of a panel
        redPanel.setBounds(0,0,250,250); //sets the Bounds of the panel to the layout of the frame
        redPanel.setLayout(new BorderLayout());// sets the internal layout of the panel to a border layout style
        
        JPanel bluePanel = new JPanel(); 
        bluePanel.setBackground(Color.blue); 
        bluePanel.setBounds(250,0,250,250);
        bluePanel.setLayout(new BorderLayout());
        
        JPanel greenPanel = new JPanel(); 
        greenPanel.setBackground(Color.green); 
        greenPanel.setBounds(0,250,500,250); 
        greenPanel.setLayout(new BorderLayout());
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exits out of the window when clicking the x
        this.setResizable(false); //hard locks the windows size so that it can not be streched by user
        this.setSize(750,750); //sets the x and y size of our frame
        this.setLayout(null); 
        this.setVisible(true);//sets the frame visablity 
        this.add(redPanel); //adds the panel to the frame
        this.add(bluePanel);
        this.add(greenPanel);
        redPanel.add(label);
        redPanel.setBorder(border); //sets the border to the label
        bluePanel.setBorder(border);
        greenPanel.setBorder(border);
        
    }
}
