
/**
 * a Door object
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Door
{
    // instance variables - replace the example below with your own
    Key keyForDoor;
    String doorName;
    boolean isLocked;

    /**
     * Constructor for objects of class Door
     */
    public Door()
    {
        // initialise instance variables
        keyForDoor = null;
        doorName = "";
        isLocked = true;

    }

    //methods
    public Key getKeyForDoor()
    {
        return keyForDoor;
    }

    public void setKeyForDoor(Key k)
    {
        keyForDoor = k;
    }

    public boolean OpenDoor(Key k)
    {
        if(k == keyForDoor)
        {
            isLocked = false;
            return isLocked;
        }
        else
        {
            //door is still locked we need the right key
            isLocked = true;
            return isLocked;
        }
    }
    
    public void setIsLocked(boolean lockable){
        isLocked = lockable;
    }
    
    public boolean getIsLocked()
    {
        return isLocked;
    }
    
    public void setDoorName(String name)
    {
        doorName = name;
    }
    
    public String getDoorName(){
        return doorName;
    }

}
