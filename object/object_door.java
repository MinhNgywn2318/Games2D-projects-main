package object;
import javax.imageio.ImageIO;

public class object_door extends SuperObject{
    public object_door(){
        name = "door";    
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/picture/object/Door.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        size = 48;
        collision = true;
    }
 
   
}
