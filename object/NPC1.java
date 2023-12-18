package object;

import javax.imageio.ImageIO;

public class NPC1 extends SuperObject{
    public NPC1(){
        name = "NPC1";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/picture/NPC_1.png"));
        } catch (Exception e) {
            e.printStackTrace();
        } 
        collision = true;
        size = 48;


    }
    
}
