package object;

import javax.imageio.ImageIO;

public class NPC2 extends SuperObject{
    public NPC2(){
        name = "NPC2";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/picture/object/NPC_2.png"));
        } catch (Exception e) {
            e.printStackTrace();
        } 
        collision = true;
        size = 48;


    }
}
