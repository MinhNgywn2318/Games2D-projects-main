package object;

import javax.imageio.ImageIO;

public class object_doll extends SuperObject{
    public object_doll(){
        name = "doll";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/picture/object/doll.png"));
        } catch (Exception e) {
            e.printStackTrace();
        } 
        collision = true;
        size = 48;


    }
}
