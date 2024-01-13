package object;

import javax.imageio.ImageIO;

public class object_squid extends SuperObject{
    public object_squid(){
        name = "squid";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/picture/object/squid.png"));
        } catch (Exception e) {
            e.printStackTrace();
        } 
        collision = true;
        size = 40;


    }
}
