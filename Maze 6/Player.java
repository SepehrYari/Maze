import java.awt.Panel;


import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * Player Class is designed to be our moving object in our maze by having positions
 * and being able to pick up keys based on location
 *
 * @author Sepehr Arya Yari
 * @version Spring 2024
 */
public class Player {
    private Point position;
     // Arrays LO 4
    private List<Key> keys;
    public boolean gotKey;
    public int x;
    public int y;
    
    /**
   * Constructor that takes x and y coordinates
   * 
   * @param y for vertical position
   * @param x for horizontal position
   */
    public Player(int x, int y) {
        position = new Point(x, y);
        keys = new ArrayList<>();
        
    }

    /**
   * Method to move the player in the x direction
   * 
   * @param deltaX for horizontal movement
   */
    public void moveX(int deltaX) {
        position.x += deltaX;
    }

    /**
   * Method to move the player in the y direction
   * 
   * @param deltaY for vertical movement
   */
    public void moveY(int deltaY) {
        position.y += deltaY;
    }

    /**
   * Method to pick up a key
   * 
   * @param Key class object
   */
    public void pickUpKey(Key key) {
        keys.add(key);
    }
    
    /**
   * Method to check if the player has the a key
   * 
   * @param Key class object
   */
    public boolean hasKey(Key key)
    {
        if(keys.contains(key))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    
    /**
   * Method to check if the player's position is the same as a key's position
   * 
   * @param Key class object
   */
    public void checkKeyPickup(Key key) {
        if (position.equals(key.getPosition())) {
            System.out.println("We picked up the " + key.getKeyName() + "! Let's find the door for it!");
            this.pickUpKey(key);
            gotKey = true;
        }
    }

    
    /**
   * Method to get the Player's position as a Point
   * 
   */
    public Point getPosition() {
        return position;
    }
    
    /**
   * Method to get the Player's x position
   * 
   */
    public int getPosX()
    {
        return x;
        
    }
    
    /**
   * Method to get the Player's y position
   * 
   */
    public int getPosY()
    {
        return y;
        
    }
}
