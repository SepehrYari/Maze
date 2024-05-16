
/**
 * this class would represent a key objects in the game.
 * it can be found inside the room class
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Key
{
    // instance variables
    private String keyName;
    private Point position;
    private ImageIcon keyPic;

    /**
     * Constructor for objects of class Key
     */
    public Key() {
        // initialise instance variables
        keyName = "key for door 1";
        position = new Point(0, 0);
        keyPic = null;
    }

    // Methods
    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String name) {
        keyName = name;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point newPosition) {
        position = newPosition;
    }

    public ImageIcon getKeyIcon() {
        return keyPic;
    }

    public void setKeyIcon(ImageIcon key) {
        keyPic = key;
    }
}
