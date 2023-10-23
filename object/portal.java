package object;

import javax.imageio.ImageIO;

import main.GamePanel;

public class portal extends SuperObject{
    GamePanel gp;
    public portal(){
        name = "portal";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/picture/object/portal.png"));
        } catch (Exception e) {
            e.printStackTrace(); 
        } 
        collision = true;
        size = 48;


    }
}
