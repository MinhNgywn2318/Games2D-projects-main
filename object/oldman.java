package object;

import javax.imageio.ImageIO;

public class oldman extends SuperObject{
    public oldman(){
        name = "oldman";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/picture/oldman.png"));
        } catch (Exception e) {
            e.printStackTrace();
        } 
        collision = true;
        size = 48;


    }
    
}
