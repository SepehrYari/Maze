
/**
 * Write a description of class BorderLayout here.
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

public class MyBorderLayout extends JFrame implements ActionListener
{
    JButton northButton;
    JButton eastButton;
    JButton southButton;
    JButton westButton;
    JButton moveButton;
    JButton interactButton;

    World earth = new World(100,100);
    Turtle t1 = new Turtle(earth);
    Player knight = new Player();
    Player.Direction direct;
    

    public MyBorderLayout() 
    {
        JLabel label = new JLabel(); // creates label which is a GUI display area for a string of text, an image, or even both
        ImageIcon image = new ImageIcon("LOGO.png"); //crates an image icon we can use
        ImageIcon picture = new ImageIcon("picture.png");

        ImageIcon northIcon = new ImageIcon("UP.jpg");
        ImageIcon eastIcon = new ImageIcon("RIGHT.png");
        ImageIcon southIcon = new ImageIcon("DOWN.jpg");
        ImageIcon westIcon = new ImageIcon("LEFT.jpg");
        ImageIcon moveIcon = new ImageIcon("MOVE.jpg");
        ImageIcon interactIcon = new ImageIcon("INTERACT");

        Border border = BorderFactory.createLineBorder(new Color(10,10,10),5); //creates a Border for to pair to a label or other object
        label.setText("Hello!");
        label.setIcon(picture); // adds a imageicon onto the label/frame

        northButton = new JButton();
        eastButton = new JButton();
        southButton = new JButton();
        westButton = new JButton();
        moveButton = new JButton();
        interactButton = new JButton();

        //sets the Icon to the button
        northButton.setIcon(northIcon);
        eastButton.setIcon(eastIcon);
        southButton.setIcon(southIcon);
        westButton.setIcon(westIcon);
        moveButton.setIcon(moveIcon);
        interactButton.setIcon(interactIcon);

        //SETS button size
        northButton.setSize(50,50);
        eastButton.setSize(50,50);
        southButton.setSize(50,50);
        westButton.setSize(50,50);
        moveButton.setSize(50,50);

        //Sets the text of the buttons
        northButton.setText("North");
        eastButton.setText("East");
        southButton.setText("South");
        westButton.setText("West");
        moveButton.setText("Move");
        interactButton.setText("Interact");

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel navigationPanel = new JPanel();
        navigationPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        panel1.setBackground(Color.red);
        panel2.setBackground(Color.green);
        panel3.setBackground(Color.yellow);
        panel4.setBackground(Color.magenta);
        panel5.setBackground(Color.blue);
        navigationPanel.setBackground(Color.gray);

        panel1.setPreferredSize(new Dimension(100, 200));
        panel2.setPreferredSize(new Dimension(100, 100));
        panel3.setPreferredSize(new Dimension(100, 100));
        panel4.setPreferredSize(new Dimension(100, 100));
        panel5.setPreferredSize(new Dimension(500, 500));
        //navigationPanel.setSize(100,100);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exits out of the window when clicking the x
        this.setResizable(false); //hard locks the windows size so that it can not be streched by user
        this.setSize(750,750); //sets the x and y size of our frame
        this.setLayout(new BorderLayout(10,10)); 
        this.setVisible(true);//sets the frame visablity 

        this.add(panel1,BorderLayout.NORTH);
        this.add(panel2,BorderLayout.WEST);
        this.add(panel3,BorderLayout.EAST);
        this.add(panel4,BorderLayout.SOUTH);
        this.add(panel5,BorderLayout.CENTER);

        panel1.setLayout(new BorderLayout(10,10));
        panel1.add(navigationPanel,BorderLayout.CENTER);
        navigationPanel.setLayout(new BorderLayout(10,10));

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 0;
        c.anchor = GridBagConstraints.PAGE_START; //top of space
        c.ipadx = 50;
        //navigationPanel.add(northButton, c);

        panel1.add(westButton, BorderLayout.WEST);
        panel1.add(northButton,BorderLayout.NORTH);
        panel1.add(eastButton,BorderLayout.EAST);
        panel1.add(southButton,BorderLayout.SOUTH);
        navigationPanel.add(moveButton,BorderLayout.WEST);
        navigationPanel.add(interactButton,BorderLayout.EAST);
        navigationPanel.add(earth, BorderLayout.CENTER);
        northButton.addActionListener(this);
        eastButton.addActionListener(this);
        southButton.addActionListener(this);
        westButton.addActionListener(this);
        moveButton.addActionListener(this);
        interactButton.addActionListener(this);

        /*
         * 
         * 
         * 
         * 
         * create a sub class to holds the set of icons per room
         * have that interact with the x and y coords of the turtle
         * use an ENUM for the orienation of our tutle to tell what image to display based on what pixel
         * 
         * 
         * 
         * 
         */

    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == northButton)
        {
            System.out.println("Face North");
            t1.turnToFace(earth.getWidth()/2, 0);
            knight.playerSetFace(direct.North);

        }

        if(e.getSource() == eastButton)
        {
            System.out.println("Face East");
            t1.turnToFace(earth.getWidth(), earth.getHeight()/2);
            knight.playerSetFace(direct.East);

        }
        if(e.getSource() == southButton)
        {
            System.out.println("Face South");
            t1.turnToFace(earth.getWidth()/2, earth.getHeight());
            knight.playerSetFace(direct.South);

        }
        if(e.getSource() == westButton)
        {
            System.out.println("Face West");
            t1.turnToFace(0, earth.getHeight()/2);
            knight.playerSetFace(direct.West);

        }
        if(e.getSource() == moveButton)
        {
            System.out.println("Move in the (Direction)");

        }
        if(e.getSource() == interactButton)
        {
            System.out.println("interact facing in (Direction)");

        }
    }

    public static void main(String[] args)
    {
        MyBorderLayout Window = new MyBorderLayout();

    }
}  