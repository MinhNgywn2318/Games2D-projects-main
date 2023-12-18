package object;
import main.GamePanel;
import javax.imageio.ImageIO;
public class monster extends SuperObject {
    GamePanel gp;

    public monster(){
        name = "monster";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/picture/object/NPC_3.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
        size = 48;

       


    }
}
