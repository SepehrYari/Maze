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

public class MyBorderLayout extends JFrame implements ActionListener {
    JButton northButton;
    JButton eastButton;
    JButton southButton;
    JButton westButton;
    JButton interactButton;

    World earth = new World(100, 100);
    Turtle t1 = new Turtle(earth);
    Player knight = new Player(0, 0);
    int Speed;

    DialogPanel textBox = new DialogPanel();

    JLabel RoomLabel;
    ImageIcon room;
    JPanel panel5;
    
    String roomName;
    Point KeyLocation = new Point(0,1);
    Key orangeKey = new Key();

    public MyBorderLayout() {

        orangeKey.setPosition(KeyLocation);
        orangeKey.setKeyName("Orange Room Key");
        
        
        northButton = createButton("UP.jpg", "North");
        eastButton = createButton("RIGHT.png", "East");
        southButton = createButton("DOWN.jpg", "South");
        westButton = createButton("LEFT.jpg", "West");
        interactButton = createButton("INTERACT", "Interact");

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel navigationPanel2 = new JPanel();
        RoomLabel = new JLabel();
        room = new ImageIcon("grey room.png");

        panel1.setBackground(new Color(30, 38, 74));
        panel2.setBackground(Color.green);
        panel3.setBackground(Color.yellow);
        panel4.setBackground(Color.magenta);
        //panel5.setBackground(Color.blue);
        navigationPanel2.setBackground(Color.gray);

        panel1.setPreferredSize(new Dimension(100, 200));
        panel2.setPreferredSize(new Dimension(100, 100));
        panel3.setPreferredSize(new Dimension(100, 100));
        panel4.setPreferredSize(new Dimension(100, 100));
        panel5.setPreferredSize(new Dimension(500, 500));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(750, 750);
        this.setLayout(new BorderLayout(10, 10));
        this.setVisible(true);
        this.setBackground(Color.BLACK);

        this.add(panel1, BorderLayout.NORTH);
        //this.add(panel2, BorderLayout.WEST);
        this.add(textBox, BorderLayout.EAST);
        this.add(panel4, BorderLayout.SOUTH);
        this.add(panel5, BorderLayout.CENTER);

        //imageResized(room);

        RoomLabel.setIcon(room);
        RoomLabel.setHorizontalAlignment(JLabel.CENTER);
        RoomLabel.setVerticalAlignment(JLabel.CENTER);

        panel5.add(RoomLabel, BorderLayout.CENTER);

        //navigationPanel2.add(earth, BorderLayout.CENTER);
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

        northButton.addActionListener(this);
        eastButton.addActionListener(this);
        southButton.addActionListener(this);
        westButton.addActionListener(this);
        interactButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == northButton) {
            t1.forward(5);
            textBox.setText("You moved towards North, let's hope this was the right move");
            knight.moveY(1);
            if (knight.getPosition().getY() < 0) {
                // If y-coordinate is less than 0, set it to 0
                knight.getPosition().setLocation(knight.getPosition().getX(), 0);
                textBox.setText("Can't move this way...");
                t1.backward(5);
            } else if (knight.getPosition().getY() > 2) {
                // If y-coordinate is greater than 2, set it to 2
                knight.getPosition().setLocation(knight.getPosition().getX(), 2);
                textBox.setText("Can't move this way...");
                t1.backward(5);
            }
            updateRoomDisplay(room);
            System.out.println(knight.getPosition());
            System.out.println(room);
        }

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
            updateRoomDisplay(room);
            System.out.println(knight.getPosition());
            System.out.println(room);
        }

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

    private ImageIcon resizeImage(ImageIcon originalIcon, int width, int height) {
        // Get the image from the original icon
        Image originalImage = originalIcon.getImage();

        // Scale the image to the desired dimensions
        Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        // Create a new ImageIcon with the scaled image
        return new ImageIcon(scaledImage);
    }

    private void updateRoomDisplay(ImageIcon RoomDisplay)
    {
        int x = (int)knight.getPosition().getX();
        int y = (int)knight.getPosition().getY();
        
        
        knight.checkKeyPickup(orangeKey);
        if(knight.gotKey){
            textBox.setText(textBox.getText() + "\n we have " + orangeKey.getKeyName() + "!");
            
        } 

        System.out.println(knight.getPosition());
        System.out.println(room);

        if (x == 0 && y == 0){
            room = new ImageIcon("grey room.png");
            roomName = "grey room";
            textBox.setText(textBox.getText() + "\n \n we are now in the " + roomName + "!");
        }
        if (x == 1 && y == 0){
            room = new ImageIcon("blue room.png");
            roomName = "blue room";
            textBox.setText(textBox.getText() + "\n \n we are now in the " + roomName + "!");
        }
        if (x == 2 && y == 0){
            room = new ImageIcon("white room.png");
            roomName = "white room";
            textBox.setText(textBox.getText() + "\n \n we are now in the " + roomName + "!");
        }
        if (x == 0 && y == 1){
            room = new ImageIcon("pink room.png");
            roomName = "pink room";
            textBox.setText(textBox.getText() + "\n \n we are now in the " + roomName + "!");
        }
        if (x == 1 && y == 1){
            room = new ImageIcon("orange room.png");
            roomName = "orange room";
            textBox.setText(textBox.getText() + "\n \n we are now in the " + roomName + "!");
        }
        if (x == 2 && y == 1){
            room = new ImageIcon("green room.png");
            roomName = "green room";
            textBox.setText(textBox.getText() + "\n \n we are now in the " + roomName + "!");
        }
        if (x == 0 && y == 2){
            room = new ImageIcon("red room.png");
            roomName = "red room";
            textBox.setText(textBox.getText() + "\n \n we are now in the " + roomName + "!");
        }
        if (x == 1 && y == 2){
            room = new ImageIcon("purple room.png");
            roomName = "purple room";
            textBox.setText(textBox.getText() + "\n \n we are now in the " + roomName + "!");
        }
        if (x == 2 && y == 2){
            room = new ImageIcon("end room.png");
            roomName = "end room";
            textBox.setText(textBox.getText() + "\n \n we are now in the " + roomName + "!");
        }

        RoomLabel.setIcon(room);
        RoomLabel.setHorizontalAlignment(JLabel.CENTER);
        RoomLabel.setVerticalAlignment(JLabel.CENTER);

        // Remove the RoomLabel from panel5
        panel5.remove(RoomLabel);

        // Resize the room icon
        room = resizeImage(room, panel5.getWidth(), panel5.getHeight());

        // Set the room icon to the RoomLabel
        RoomLabel.setIcon(room);

        // Add the RoomLabel back to panel5 with BorderLayout.CENTER constraint
        panel5.add(RoomLabel, BorderLayout.CENTER);
        
        //add here the name of the room

        // Repaint panel5 to reflect changes
        panel5.revalidate();
        panel5.repaint();
        

    }

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

    private JPanel createPanel(Color color, LayoutManager layout, Dimension dimension) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.setLayout(layout);
        if (dimension != null)
            panel.setPreferredSize(dimension);
        return panel;
    }

}
