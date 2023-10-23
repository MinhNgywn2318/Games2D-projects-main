package object;
import main.GamePanel;
import javax.imageio.ImageIO;
public class apple extends SuperObject {
    GamePanel gp;

    public apple(){
        name = "apple";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/picture/object/apple.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
        size = 48;
    }
}
