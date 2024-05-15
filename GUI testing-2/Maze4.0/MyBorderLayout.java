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
    

    DialogPanel textBox = new DialogPanel();

    public MyBorderLayout() {
        
        t1.penUp();
        t1.moveTo(5,5);
        t1.penDown();
        //earth.setPicture(miniMap);
        
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

        panel1.setBackground(new Color(30, 38, 74));
        panel2.setBackground(Color.green);
        panel3.setBackground(Color.yellow);
        panel4.setBackground(Color.magenta);
        panel5.setBackground(Color.blue);
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
        this.add(panel2, BorderLayout.WEST);
        this.add(textBox, BorderLayout.EAST);
        this.add(panel4, BorderLayout.SOUTH);
        this.add(panel5, BorderLayout.CENTER);

        
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
            System.out.println("Face North");
            t1.forward(5);
            textBox.setText("You moved towards North, let's hope this was the right move");
        }

        if (e.getSource() == eastButton) {
            System.out.println("Face East");
            t1.right(5);
            textBox.setText("You moved towards East, let's hope this was the right move");
        }
        if (e.getSource() == southButton) {
            System.out.println("Face South");
            t1.backward(5);
            textBox.setText("You moved towards South, let's hope this was the right move");
        }
        if (e.getSource() == westButton) {
            System.out.println("Face West");
            t1.left(5);
            textBox.setText("You moved towards West, let's hope this was the right move");
        }
        if (e.getSource() == interactButton) {
            System.out.println("Interact");
        }
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
