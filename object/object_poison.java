package object;

import javax.imageio.ImageIO;

public class object_poison extends SuperObject{
    public object_poison(){
        name = "poison";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/picture/object/Poison.png"));
        } catch (Exception e) {
            e.printStackTrace();
        } 
        collision = true;
        size = 40;


    }
}
