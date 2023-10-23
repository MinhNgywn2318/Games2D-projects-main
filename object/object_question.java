package object;
import javax.imageio.ImageIO;
public class object_question extends SuperObject {
    public object_question(){
        name = "question";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/picture/object/question.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        size = 48;
        collision = true;

    }
}
