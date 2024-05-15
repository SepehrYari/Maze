
/**
 * Write a description of class GameSetUp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameSetUp
{
    Key greyKey;
    Key blueKey;
    Key redKey;
    Key orangeKey;
    Key whiteKey;
    Key purpleKey;
    Key greenKey;
    Key endKey;
    
    Door GreyDoor;
    Door BlueDoor;
    Door RedDoor;
    Door OrangeDoor;
    Door WhiteDoor;
    Door PurpleDoor;
    Door GreenDoor;
    Door EndDoor;
    
    Room Grey;
    Room Blue;
    Room Red;
    Room Orange;
    Room White;
    Room Purple;
    Room Green;
    Room End;
    

    public void gameSetUP(){
        World w = new World(50,50);

        
        greyKey.setCoords(0,0);
        blueKey.setCoords(0,1);
        redKey.setCoords(1,0);
        orangeKey.setCoords(0,2);
        whiteKey.setCoords(1,1);
        purpleKey.setCoords(2,0);
        greenKey.setCoords(1,2);
        endKey.setCoords(2,1);
        
        Grey.setDoorInRoom(GreyDoor, greyKey);
        Blue.setDoorInRoom(BlueDoor, blueKey);
        Red.setDoorInRoom(RedDoor, redKey);
        Orange.setDoorInRoom(OrangeDoor, orangeKey);
        White.setDoorInRoom(WhiteDoor, whiteKey);
        Purple.setDoorInRoom(PurpleDoor, purpleKey);
        Green.setDoorInRoom(GreenDoor, greenKey);
        End.setDoorInRoom(EndDoor, endKey);
        
        GreyDoor.setKeyForDoor(greyKey);
        BlueDoor.setKeyForDoor(blueKey);
        RedDoor.setKeyForDoor(redKey);
        OrangeDoor.setKeyForDoor(orangeKey);
        WhiteDoor.setKeyForDoor(whiteKey);
        PurpleDoor.setKeyForDoor(purpleKey);
        GreenDoor.setKeyForDoor(greenKey);
        EndDoor.setKeyForDoor(endKey);
        
        Turtle Bilfred = new Turtle(0,0, w);
    
        int x = Bilfred.getXPos();
        int y = Bilfred.getYPos();
        
        if(x == 0 && y == 0)
        {
            GreyDoor.OpenDoor(greyKey);
        
        }
        else if(x == 0 && y == 1)
        {
        
        }
        
        
        
        
        
    }
    
}
