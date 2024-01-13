package object;

import javax.imageio.ImageIO;

public class object_potion1 extends SuperObject{
    public object_potion1(){
        name = "potion1";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/picture/object/potion1.png"));
        } catch (Exception e) {
            e.printStackTrace();
        } 
        collision = true;
        size = 40;


    }
}
