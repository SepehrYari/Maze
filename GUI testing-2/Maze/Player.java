
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
     public enum Direction { 
         North, East, South, West
        }

    Direction face;
    
    public void playerSetFace(Direction direct)
    {
        face = direct;
        double degrees = 360;
        if(face == Direction.North)
        {
            
        }
        
        if(face == Direction.East)
        {
            
        }
        
        if(face == Direction.South)
        {
            
        }
        
        if(face == Direction.West)
        {
            
        }
    }
    
    public Direction playerGetFace()
    {
        
        return face;
        
    }
}
