
/**
 * Write a description of class ChildJframe here.
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

public class MyFrame extends JFrame
{

    public MyFrame()
    {

        //JFrame frame = new JFrame(); //creates a frame

        JLabel label = new JLabel(); // creates label which is a GUI display area for a string of text, an image, or even both

        ImageIcon image = new ImageIcon("LOGO.png"); //crates an image icon we can use
        ImageIcon picture = new ImageIcon("picture.png");
        Border border = BorderFactory.createLineBorder(Color.green,5); //creates a Border for to pair to a label or other object

        label.setText("Bro, do you even code?");//sets the text of the label
        label.setIcon(picture); // adds a imageicon onto the label/frame
        label.setHorizontalTextPosition(JLabel.CENTER); //sets the text to LEFT, CENTER or RIGHT of an imageicon for the x axis positions
        label.setVerticalTextPosition(JLabel.TOP); //sets the text to TOP, CENTER, or BOTTOM of an imageicon for the y axis positions
        label.setForeground(new Color(100,50,120)); //sets the color of text
        label.setFont(new Font("MS PMincho",Font.BOLD,20)); //sets the font type, text type, and text size
        label.setIconTextGap(100); //set gap of text to the image/icon
        label.setBackground(new Color(40,40,40)); //change color of the Label background
        label.setOpaque(true); //display the background color
        label.setBorder(border); //sets the border to the label
        label.setVerticalAlignment(JLabel.CENTER); //sets the verical possion of the Icon and Text
        label.setHorizontalAlignment(JLabel.CENTER); //sets the Horizontal possion of the Icon and Text
        
        label.setBounds(0,0,250,250); //set the x and y postion within the frame and then set the dimentions of the label within the frame
        

        this.setTitle("JFrame title goes here"); //set the name of the whole window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exits out of the window when clicking the x
        this.setResizable(false); //hard locks the windows size so that it can not be streched by user
        this.setSize(750,750); //sets the x and y size of our frame
        this.setLayout(null); 
        
        this.setVisible(true);//sets the frame visablity 
        this.add(label);//adds the label onto the frame
        this.setIconImage(image.getImage()); //sets the frame's icon to the image we created 

        this.getContentPane().setBackground(new Color(210,210,210)); //change color of the window background
        
        //this.pack(); //sets the size of our frame to the componets/labels within it

    }
}
