package main;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
public class tools {
    public BufferedImage scaleImage(BufferedImage source, int width, int height){
        BufferedImage scaleImage = new BufferedImage(width, height,source.getType());
        Graphics2D g2 = scaleImage.createGraphics();
        g2.drawImage(source, 0, 0,width,height,null);
        g2.dispose();
        return scaleImage;
    }
}
