package object;

import javax.imageio.ImageIO;

public class prince extends SuperObject {
    public prince(){
        name = "prince";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/picture/object/prince.png"));
        } catch (Exception e) {
            e.printStackTrace();
        } 
        collision = true;
        size = 48;


    }
    
}
