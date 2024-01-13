package object;

import javax.imageio.ImageIO;

public class princess extends SuperObject {
    public princess(){
        name = "princess";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/picture/object/Princess.png"));
        } catch (Exception e) {
            e.printStackTrace();
        } 
        collision = true;
        size = 48;


    }
    
}
