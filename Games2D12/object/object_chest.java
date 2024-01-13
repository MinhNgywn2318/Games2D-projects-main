package object;
import main.GamePanel;
import javax.imageio.ImageIO;
import java.util.Objects;

public class object_chest extends SuperObject {
    GamePanel gp;

    public object_chest(){
        name = "chest";
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/picture/object/Closed_chest.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
        size = 48;

       


    }
}
