package object;
import javax.imageio.ImageIO;

public class object_Key extends SuperObject{
    public object_Key(){
        name = "key";    
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/picture/object/key.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        size = 48;
    }
 
   
}
