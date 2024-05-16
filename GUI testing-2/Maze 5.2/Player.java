import java.awt.Panel;

/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private Point position;
    private List<Key> keys;
    public boolean gotKey;

    public Player(int x, int y) {
        position = new Point(x, y);
        keys = new ArrayList<>();
    }

    // Method to move the player in the x direction
    public void moveX(int deltaX) {
        position.x += deltaX;
    }

    // Method to move the player in the y direction
    public void moveY(int deltaY) {
        position.y += deltaY;
    }

    // Method to pick up a key
    public void pickUpKey(Key key) {
        keys.add(key);
    }
    
    // Method to check if the player's position is the same as a key's position
    public void checkKeyPickup(Key key) {
        if (position.equals(key.getPosition())) {
            System.out.println("We picked up the " + key.getKeyName() + "! Let's find the door for it!");
            this.pickUpKey(key);
            gotKey = true;
        }
    }

    // Getters for position and keys
    public Point getPosition() {
        return position;
    }

    public List<Key> getKeys() {
        return keys;
    }
}
