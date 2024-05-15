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

    // Getters for position and keys
    public Point getPosition() {
        return position;
    }

    public List<Key> getKeys() {
        return keys;
    }
}
