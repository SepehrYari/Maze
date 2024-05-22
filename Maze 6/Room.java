
/**
 * Each Room wpuld represent a portion of a maze. it should containe properties
 * such as whether there is a wall in any of the 4 directions (north, east, south, west)
 * whether there's a key in the room, and whether there's a door in the room or not
 *
 * @author Sepehr yari, 
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;

public class Room
{
    // instance variables - replace the example below with your own
    Key keys;
    Door door;
    int x;
    int y;
    boolean isWall;
    boolean isPath;
    
    

    /**
     * Constructor for objects of class Room
     */
    public Room()
    {
        // initialise instance variables
        keys = null;
        door = null;
        x = 0;
        y = 0;
        
    }
    
    //methods
    
    public void setDoorInRoom(Door Doorway,Key keyItem)
    {
        door = Doorway;
        door.setKeyForDoor(keyItem);
    }
    
    public Door getDoorInRoom(){
        return door;
    }
    
    
    public int getKeyX()
    {
        return x;
    }
    
    public int getKeyY()
    {
        return y;
    }
    
    public void setKeyX(int newX)
    {
        x = newX;
    }
    
    public void setKeyY(int newY)
    {
        y = newY;
    }
    
    

}
