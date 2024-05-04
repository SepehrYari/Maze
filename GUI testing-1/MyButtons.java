
/**
 * Write a description of class MyButtons here.
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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyButtons extends JFrame implements ActionListener
{

    JButton button;

    public MyButtons()
    {
        JLabel label = new JLabel(); // creates label which is a GUI display area for a string of text, an image, or even both
        ImageIcon image = new ImageIcon("LOGO.png"); //crates an image icon we can use
        ImageIcon picture = new ImageIcon("picture.png");
        Border border = BorderFactory.createLineBorder(new Color(10,10,10),5); //creates a Border for to pair to a label or other object
        label.setText("Hello!");
        label.setIcon(picture); // adds a imageicon onto the label/frame

        button = new JButton();
        
        button.setBounds(200,100,200,50);
        button.addActionListener(this);
        button.setFocusable(false);
        button.setText("Print message");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exits out of the window when clicking the x
        this.setResizable(false); //hard locks the windows size so that it can not be streched by user
        this.setSize(750,750); //sets the x and y size of our frame
        this.setLayout(null); 
        this.setVisible(true);//sets the frame visablity 
        this.add(button);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == button)
        {
            System.out.println("Hello World");
            /*
             * move turtle
             * face west
             * display icon
             * 
             */
            
        }

    }

}

