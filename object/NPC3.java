package object;
import main.GamePanel;
import javax.imageio.ImageIO;
public class NPC3 extends SuperObject {
    GamePanel gp;

    public NPC3(){
        name = "NPC3";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/picture/object/NPC_3.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
        size = 48;

       


    }
}
