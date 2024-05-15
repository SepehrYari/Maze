
/**
 * this class would represent a key objects in the game.
 * it can be found inside the room class
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Key
{
    // instance variables - replace the example below with your own
    String keyName;
    int x;
    int y;
    

    /**
     * Constructor for objects of class Key
     */
    public Key()
    {
        // initialise instance variables
        keyName = "key for door 1";
        x = 0;
        y = 0;
        
    }

    //methods
    public String getKeyName()
    {
        return keyName;
    }
    
    public void setKeyName(String name)
    {
        keyName = name;
    }
    
    public int getKeyX()
    {
        return x;
    }
    
    public int getKeyY()
    {
        return y;
    }
    
    public void setCoords(int newX,int newY)
    {
        x = newX;
        y = newY;
    }
    
    
    
}
