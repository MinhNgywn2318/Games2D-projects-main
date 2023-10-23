package object;

import javax.imageio.ImageIO;

public class object_potion2 extends SuperObject{
    public object_potion2(){
        name = "potion2";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/picture/object/potion2.png"));
        } catch (Exception e) {
            e.printStackTrace();
        } 
        collision = true;
        size = 40;


    }
}
