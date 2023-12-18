package object;
import main.GamePanel;
import javax.imageio.ImageIO;
public class object_chest extends SuperObject {
    GamePanel gp;

    public object_chest(){
        name = "chest";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/picture/object/Closed_chest.png.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
        size = 48;

       


    }
}
