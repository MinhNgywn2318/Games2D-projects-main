package picture;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class picture {
    public BufferedImage image = null;

    public BufferedImage get(String imageName) {
        try {
           image =  ImageIO.read(getClass().getResourceAsStream("/picture/"+ imageName +".png"));
        } catch (Exception e) {
           e.printStackTrace();
        }
        return image;
     }
     public BufferedImage get1(String imageName) {
      try {
         image =  ImageIO.read(getClass().getResourceAsStream("/picture/"+ imageName));
      } catch (Exception e) {
         e.printStackTrace();
      }
      return image;
   }
}
