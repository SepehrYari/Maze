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
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

import java.io.*;
import java.awt.geom.*;
import javax.swing.*; 

import java.awt.font.*;
import java.awt.geom.*;
import java.util.Observer;
import java.util.Random;

/**
 * this is the main body of the game where all of the logic and actions occur
 *
 * sets up the GUI and is also 
 * what we will be using to keep track of the player, keys, & rooms.
 *
 * @author Sepehr, Jacob, Diego
 * @version Spring 2024
 */
// GUI LO 12
public class MyGame extends JFrame implements ActionListener {
    /**
     * Creates the MyGameLayout Class that Utilizes J frames, Labels, Buttons, and Panels that will be used in order to initialize the GUI based on an Action Listener 
     */

    JButton northButton;
    JButton eastButton;
    JButton southButton;
    JButton westButton;
    JButton interactButton;

    /**
     * Creates the world in which the Turtle or "player" can navigate. 
     */
    World earth = new World(100, 100);
    Turtle t1 = new Turtle(earth);
    int penWidth = 3;
    Player knight = new Player(0, 0);

    /**
     * Creates a Dialog panel that will be used to display information to the player based on in game actions. 
     */
    DialogPanel textBox = new DialogPanel();

    JLabel RoomLabel;
    ImageIcon room;
    JPanel panel5;
    JPanel panel4;

    /**
     * Sets up point based x, y coordinate system that will keep track of the location of each room and the keys in which they correspond to 
     */
    JLabel orangeKeyLabel;
    JLabel blueKeyLabel;
    JLabel whiteKeyLabel;
    JLabel redKeyLabel;
    JLabel purpleKeyLabel;
    JLabel pinkKeyLabel;
    JLabel greenKeyLabel;
    JLabel endKeyLabel;

    String roomName;
    Point KeyLocation = new Point(0,2);
    Key orangeKey = new Key();

    Point KeyLocation2 = new Point(0,1);
    Key blueKey = new Key();

    Point KeyLocation3 = new Point(1,1);
    Key whiteKey = new Key();

    Point KeyLocation4 = new Point(1,0);
    Key redKey = new Key();

    Point KeyLocation5 = new Point(2,0);
    Key purpleKey = new Key();

    Point KeyLocation6 = new Point(0,0);
    Key pinkKey = new Key();

    Point KeyLocation7 = new Point(1,2);
    Key greenKey = new Key();

    Point KeyLocation8 = new Point(2,1);
    Key EndKey = new Key();

    /**
     * Constructor as a defult
     * Sets up variables and passthroughs using insantce 
     * variables set up earlier.
     */
    public MyGame() {

        /**
         * Passes the KeyLocation set up earlier and assignes the locations to the colored keys. 
         */
        orangeKey.setPosition(KeyLocation);
        blueKey.setPosition(KeyLocation2);
        whiteKey.setPosition(KeyLocation3);
        redKey.setPosition(KeyLocation4);
        purpleKey.setPosition(KeyLocation5);
        pinkKey.setPosition(KeyLocation6);
        greenKey.setPosition(KeyLocation7);
        EndKey.setPosition(KeyLocation8);

        /**
         * Sets the key names as string to be able to be 
         * used to display in the text box.
         */

        orangeKey.setKeyName("Orange Room Key");
        blueKey.setKeyName("blue Room Key");
        whiteKey.setKeyName("white Room Key");
        redKey.setKeyName("red Room Key");
        purpleKey.setKeyName("purple Room Key");
        pinkKey.setKeyName("pink Room Key");
        greenKey.setKeyName("green Room Key");
        EndKey.setKeyName("End Room Key");

        /**
         * Creates 5 J buttons and names them so that 
         * they can be called later. 
         */

        northButton = createButton("UP.jpg", "North");
        eastButton = createButton("RIGHT.png", "East");
        southButton = createButton("DOWN.jpg", "South");
        westButton = createButton("LEFT.jpg", "West");
        interactButton = createButton("INTERACT", "Interact");

        /**
         * Creates 5 new J Panels inside of the GUI
         */

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel navigationPanel2 = new JPanel();
        RoomLabel = new JLabel();
        room = new ImageIcon("grey room.png");

        /**
         * sets the colors to differentiat the panels 
         */

        panel1.setBackground(new Color(30, 38, 74));
        panel2.setBackground(Color.green);
        panel3.setBackground(Color.yellow);
        panel4.setBackground(new Color(30, 38, 74));
        navigationPanel2.setBackground(Color.gray);

        /**
         * Sets the Dimensions of the 5 J panels
         */

        panel1.setPreferredSize(new Dimension(100, 200));
        panel2.setPreferredSize(new Dimension(100, 100));
        panel3.setPreferredSize(new Dimension(100, 100));
        panel4.setPreferredSize(new Dimension(100, 100));
        panel5.setPreferredSize(new Dimension(500, 500));

        /**
         * This sets up the main window that houses each J panel 
         */

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(750, 750);
        this.setLayout(new BorderLayout(10, 10));
        this.setVisible(true);
        this.setBackground(Color.BLACK);

        /**
         * This sets up the Layout of the panels for the 
         * buttons to use later. 
         */

        this.add(panel1, BorderLayout.NORTH);
        this.add(textBox, BorderLayout.EAST);
        this.add(panel4, BorderLayout.SOUTH);
        this.add(panel5, BorderLayout.CENTER);

        /**
         * This creats a label for the room pictures
         */

        RoomLabel.setIcon(room);
        RoomLabel.setHorizontalAlignment(JLabel.CENTER);
        RoomLabel.setVerticalAlignment(JLabel.CENTER);
        RoomLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 30));
        
        /**
         * Adds the Label to the J panel 
         */
        panel5.add(RoomLabel, BorderLayout.CENTER);

        /**
         * This is the Layout of all the J Buttons
         */

        GridBagConstraints gbc = new GridBagConstraints();
        panel1.setLayout(new GridBagLayout());
        navigationPanel2.setLayout(new GridBagLayout());

        gbc.insets = new Insets(3, 3, 3, 3);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.ipadx = 30;
        gbc.ipady = 20;

        gbc.weightx = 0; // Set the horizontal weight to make the button expand horizontally
        gbc.weighty = 0; // Set the vertical weight to make the button expand vertically

        panel1.add(northButton, gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        panel1.add(eastButton, gbc);

        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.ipadx = 105;
        gbc.ipady = 105;
        gbc.weightx = 0;
        panel1.add(navigationPanel2, gbc);

        gbc.weightx = 0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipadx = 30;
        gbc.ipady = 20;
        panel1.add(westButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel1.add(southButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel1.add(interactButton, gbc);

        navigationPanel2.add(earth);

        /**
         * adds an Action Listener to all of the Buttons on
         * the navigation panel
         */

        northButton.addActionListener(this);
        eastButton.addActionListener(this);
        southButton.addActionListener(this);
        westButton.addActionListener(this);
        interactButton.addActionListener(this);

        /**
         * This is the ImageIcons and Labels that were used 
         * to make the player's inventory
         */

        ImageIcon orangeKeyIcon = new ImageIcon("orangeKey.png");
        ImageIcon blueKeyIcon = new ImageIcon("blueKey.png");
        ImageIcon whiteKeyIcon = new ImageIcon("whiteKey.png");
        ImageIcon redKeyIcon = new ImageIcon("redKey.png");
        ImageIcon purpleKeyIcon = new ImageIcon("purpleKey.png");
        ImageIcon pinkKeyIcon = new ImageIcon("pinkKey.png");
        ImageIcon greenKeyIcon = new ImageIcon("greenKey.png");
        ImageIcon endKeyIcon = new ImageIcon("endKey.png");

        orangeKeyLabel = new JLabel(resizeImage(orangeKeyIcon, 50, 50));
        blueKeyLabel = new JLabel(resizeImage(blueKeyIcon, 50, 50));
        whiteKeyLabel = new JLabel(resizeImage(whiteKeyIcon, 50, 50));
        redKeyLabel = new JLabel(resizeImage(redKeyIcon, 50, 50));
        purpleKeyLabel = new JLabel(resizeImage(purpleKeyIcon, 50, 50));
        pinkKeyLabel = new JLabel(resizeImage(pinkKeyIcon, 50, 50));
        greenKeyLabel = new JLabel(resizeImage(greenKeyIcon, 50, 50));
        endKeyLabel = new JLabel(resizeImage(endKeyIcon, 50, 50));

        /**
         * set all the keys except the pink key invisible to reveal the keys
         * later when we find them
         */

        pinkKeyLabel.setVisible(true);
        blueKeyLabel.setVisible(false);
        orangeKeyLabel.setVisible(false);
        redKeyLabel.setVisible(false);
        purpleKeyLabel.setVisible(false);
        whiteKeyLabel.setVisible(false);
        greenKeyLabel.setVisible(false);
        endKeyLabel.setVisible(false);

        panel4.add(pinkKeyLabel);
        panel4.add(blueKeyLabel);
        panel4.add(orangeKeyLabel);
        panel4.add(redKeyLabel);
        panel4.add(purpleKeyLabel);
        panel4.add(whiteKeyLabel);
        panel4.add(greenKeyLabel);
        panel4.add(endKeyLabel);
    }

    // user input LO 6 
    /**
     * Action Listener Method to move the player and update the display
     * after every button press
     * 
     * This is where the actions occure when a button is pressed. 
     * 
     * @param ActionEvent for when the button is pressed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        /**
         * If Else statement chain were action event e is set to equal north button and 
         * updates knights position and display
         */

        if (e.getSource() == northButton) {
            // variables LO 1
            t1.setPenWidth(penWidth);
            t1.forward(5);
            textBox.setText("You moved towards North, let's hope this was the right move");
            knight.moveY(1);
            if (knight.getPosition().getY() < 0) {
                // If y-coordinate is less than 0, set it to 0
                //Using Methods LO 2
                knight.getPosition().setLocation(knight.getPosition().getX(), 0);
                textBox.setText("Can't move this way...");
                t1.backward(5);
            } else if (knight.getPosition().getY() > 2) {
                // If y-coordinate is greater than 2, set it to 2
                knight.getPosition().setLocation(knight.getPosition().getX(), 2);
                textBox.setText("Can't move this way...");
                t1.backward(5);
            }
            else if (knight.getPosition().getX() == 0 && knight.getPosition().getY() == 2 && knight.hasKey(redKey) == false) 
            {
                // Checks if the Knight has keys and displays message informing player cantmove to x room.
                textBox.setText("Can't move this way...");
                knight.getPosition().setLocation(knight.getPosition().getX(), 1);
                t1.backward(5);
            }
            else if(knight.getPosition().getX() == 1 && knight.getPosition().getY() == 2 && knight.hasKey(purpleKey) == false) 
            {
                // File I/O LO 10
                textBox.setText("Can't move this way...");
                knight.getPosition().setLocation(knight.getPosition().getX(), 1);
                t1.backward(5);
            }
            else if(knight.getPosition().getX() == 1 && knight.getPosition().getY() == 2 && knight.hasKey(purpleKey) == false) 
            {
                textBox.setText("Can't move this way...");
                knight.getPosition().setLocation(knight.getPosition().getX(), 1);
                t1.backward(5);
            }
            else if(knight.getPosition().getX() == 2 && knight.getPosition().getY() == 2 && knight.hasKey(EndKey) == false) 
            {
                textBox.setText("Can't move this way...");
                knight.getPosition().setLocation(knight.getPosition().getX(), 1);
                t1.backward(5);
            }
            else if (knight.getPosition().getX() == 2 && knight.getPosition().getY() == 2 && knight.hasKey(EndKey) == false) {
                // If y-coordinate is greater than 2, set it to 2
                knight.getPosition().setLocation(knight.getPosition().getX(), 1);
                textBox.setText("Can't move this way... ");
                t1.left(5);
            }
            /**
             * Updates the room display every time an action event occurs in all buttons
             */
            updateRoomDisplay(room);
            System.out.println(knight.getPosition());
            System.out.println(room);
        }

        /**
         * If Else statement chain were action event e is set to equal east button and 
         * updates knights position and display
         */
        
        if (e.getSource() == eastButton) {
            t1.right(5);
            textBox.setText("You moved towards East, let's hope this was the right move");
            knight.moveX(1);
            if (knight.getPosition().getX() < 0) {
                // If y-coordinate is less than 0, set it to 0
                knight.getPosition().setLocation(0, knight.getPosition().getY());
                textBox.setText("Can't move this way...");
                t1.left(5);
            } else if (knight.getPosition().getX() > 2) {
                // If y-coordinate is greater than 2, set it to 2
                knight.getPosition().setLocation(2, knight.getPosition().getY());
                textBox.setText("Can't move this way...");
                t1.left(5);
            }
            else if (knight.getPosition().getX() == 1 && knight.getPosition().getY() == 1 && knight.hasKey(orangeKey) == false) {
                // If y-coordinate is greater than 2, set it to 2
                knight.getPosition().setLocation(0, knight.getPosition().getY());
                textBox.setText("Can't move this way... ");
                t1.left(5);
            }
            else if (knight.getPosition().getX() == 1 && knight.getPosition().getY() == 2 && knight.hasKey(purpleKey) == false) {
                // If y-coordinate is greater than 2, set it to 2
                knight.getPosition().setLocation(0, knight.getPosition().getY());
                textBox.setText("Can't move this way... ");
                t1.left(5);
            }
            else if (knight.getPosition().getX() == 1 && knight.getPosition().getY() == 0 && knight.hasKey(blueKey) == false) {
                // If y-coordinate is greater than 2, set it to 2
                knight.getPosition().setLocation(0, knight.getPosition().getY());
                textBox.setText("Can't move this way... you need blue Key ");
                t1.left(5);
            }
            else if (knight.getPosition().getX() == 2 && knight.getPosition().getY() == 1 && knight.hasKey(greenKey) == false) {
                // If y-coordinate is greater than 2, set it to 2
                knight.getPosition().setLocation(1, knight.getPosition().getY());
                textBox.setText("Can't move this way... you need green key");
                t1.left(5);
            }
            else if (knight.getPosition().getX() == 2 && knight.getPosition().getY() == 0 && knight.hasKey(whiteKey) == false) {
                // If y-coordinate is greater than 2, set it to 2
                knight.getPosition().setLocation(1, knight.getPosition().getY());
                textBox.setText("Can't move this way... ");
                t1.left(5);
            }

            updateRoomDisplay(room);
            System.out.println(knight.getPosition());
            System.out.println(room);
        }
        
        /**
         * If Else statement chain were action event e is set to equal south button and 
         * updates knights position and display
         */
        
        if (e.getSource() == southButton) {
            t1.backward(5);
            textBox.setText("You moved towards South, let's hope this was the right move");
            knight.moveY(-1);
            if (knight.getPosition().getY() < 0) {
                // If y-coordinate is less than 0, set it to 0
                knight.getPosition().setLocation(knight.getPosition().getX(), 0);
                textBox.setText("Can't move this way...");
                t1.forward(5);
            } else if (knight.getPosition().getY() > 2) {
                // If y-coordinate is greater than 2, set it to 2
                knight.getPosition().setLocation(knight.getPosition().getX(), 2);
                textBox.setText("Can't move this way...");
                t1.forward(5);
            }

            updateRoomDisplay(room);
            System.out.println(knight.getPosition());
            System.out.println(room);
        }

        /**
         * If Else statement chain were action event e is set to equal west button and 
         * updates knights position and display
         */
        
        
        if (e.getSource() == westButton) {
            t1.left(5);
            textBox.setText("You moved towards West, let's hope this was the right move");
            knight.moveX(-1);
            if (knight.getPosition().getX() < 0) {
                // If y-coordinate is less than 0, set it to 0
                knight.getPosition().setLocation(0, knight.getPosition().getY());
                textBox.setText("Can't move this way...");
                t1.right(5);
            } else if (knight.getPosition().getX() > 2) {
                // If y-coordinate is greater than 2, set it to 2
                knight.getPosition().setLocation(2, knight.getPosition().getY());
                textBox.setText("Can't move this way...");
                t1.right(5);
            }
            updateRoomDisplay(room);
        }

        if (e.getSource() == interactButton) {
            System.out.println("Interact");
        }
    }

     /**
     * Future test method to resize image Icons.
     */
    
    private ImageIcon resizeImage(ImageIcon originalIcon, int width, int height) {
        // Get the image from the original icon
        Image originalImage = originalIcon.getImage();

        // Scale the image to the desired dimensions
        Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        // Create a new ImageIcon with the scaled image
        return new ImageIcon(scaledImage);
    }
    // conditionals LO 7
    /**
     * Sets up x, y coordinates that displays an image based on the currnet 
     * Coordiantes of the Player.
     */
    private void updateRoomDisplay(ImageIcon RoomDisplay)
    {
        int x = (int)knight.getPosition().getX();
        int y = (int)knight.getPosition().getY();

        System.out.println(knight.getPosition());
        System.out.println(room);

        if (x == 0 && y == 0){
            room = new ImageIcon("grey room.png");
            roomName = "grey room";
            knight.pickUpKey(pinkKey);
            pinkKeyLabel.setVisible(true);
            

            textBox.setText(textBox.getText() + "\n \n we are now in the " + roomName + "!" + " you have collected " + pinkKey.getKeyName());
        }

        if (x == 1 && y == 0){
            room = new ImageIcon("blue room.png");
            roomName = "blue room";
            knight.pickUpKey(redKey);
            redKeyLabel.setVisible(true);

            textBox.setText(textBox.getText() + "\n \n we are now in the " + roomName + "!");
        }
        if (x == 2 && y == 0){
            room = new ImageIcon("white room.png");
            roomName = "white room";
            knight.pickUpKey(purpleKey);
            purpleKeyLabel.setVisible(true);

            textBox.setText(textBox.getText() + "\n \n we are now in the " + roomName + "!" );
        }
        if (x == 0 && y == 1){
            room = new ImageIcon("pink room.png");
            roomName = "pink room";
            knight.pickUpKey(blueKey);
            blueKeyLabel.setVisible(true);

            textBox.setText(textBox.getText() + "\n \n we are now in the " + roomName + "!");
        }
        if (x == 1 && y == 1){
            room = new ImageIcon("orange room.png");
            roomName = "orange room";
            knight.pickUpKey(whiteKey);
            whiteKeyLabel.setVisible(true);

            textBox.setText(textBox.getText() + "\n \n we are now in the " + roomName + "!");
        }
        if (x == 2 && y == 1){
            room = new ImageIcon("green room.png");
            roomName = "green room";
            knight.pickUpKey(EndKey);
            endKeyLabel.setVisible(true);

            textBox.setText(textBox.getText() + "\n \n we are now in the " + roomName + "!");
        }
        if (x == 0 && y == 2){
            room = new ImageIcon("red room.png");
            roomName = "red room";
            knight.pickUpKey(orangeKey);
            orangeKeyLabel.setVisible(true);

            textBox.setText(textBox.getText() + "\n \n we are now in the " + roomName + "!");
        }
        if (x == 1 && y == 2){
            room = new ImageIcon("purple room.png");
            roomName = "purple room";
            knight.pickUpKey(greenKey);
            greenKeyLabel.setVisible(true);

            textBox.setText(textBox.getText() + "\n \n we are now in the " + roomName + "!");
        }
        if (x == 2 && y == 2){
            room = new ImageIcon("end room.png");
            roomName = "end room";
            textBox.setText(textBox.getText() + "\n \n we are now in the " + roomName + "!" + " Congrats, you beat the Maze!");
        }

        RoomLabel.setIcon(room);
        RoomLabel.setHorizontalAlignment(JLabel.CENTER);
        RoomLabel.setVerticalAlignment(JLabel.CENTER);

        // Remove the RoomLabel from panel5
        panel5.remove(RoomLabel);

        // Resize the room icon
        //possibly not working???
        room = resizeImage(room, panel5.getWidth(), panel5.getHeight());

        // Set the room icon to the RoomLabel
        RoomLabel.setIcon(room);

        // Add the RoomLabel back to panel5 with BorderLayout.CENTER constraint
        panel5.add(RoomLabel, BorderLayout.CENTER);

        // Repaint panel5 to reflect changes
        panel5.revalidate();
        panel5.repaint();

    }

     /**
     * Method to create the navigation Buttons settings. 
     */
    private JButton createButton(String iconName, String text) {
        JButton button = new JButton();
        button.setText(text);
        button.setIcon(new ImageIcon(iconName));
        button.setSize(100, 100);
        button.setPreferredSize(new Dimension(100, 100));
        button.setBackground(Color.BLACK); // Change background color
        button.setForeground(Color.GREEN); // Change text color
        button.setFont(new Font("Arial", Font.BOLD, 16)); // Change font
        button.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2)); // Change border
        return button;
    }

    
    /**
     * Method to create J panels 
     */
    private JPanel createPanel(Color color, LayoutManager layout, Dimension dimension) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.setLayout(layout);
        if (dimension != null)
            panel.setPreferredSize(dimension);
        return panel;
    }

}
