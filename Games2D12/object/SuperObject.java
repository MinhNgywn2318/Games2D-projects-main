package object;
import java.awt.image.BufferedImage;
import main.GamePanel;

import java.awt.Graphics2D;
import java.awt.Rectangle;


public abstract class SuperObject{
    
    public Rectangle solidArea = new Rectangle(0, 0,48,48);
    public int solidAreaDefaultX,solidAreaDefaultY;
    public BufferedImage image;
     public int worldX, worldY;
     public boolean collision = false;
     public String name;
     public int size;
     public String text;


     public void draw(Graphics2D g,GamePanel gp) { 
      
        int screenX = worldX -gp.player.worldX + gp.player.screenX;
        int screenY = worldY -gp.player.worldY + gp.player.screenY;
        if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
        worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
        worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
        worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){
            g.drawImage(image, screenX, screenY,size,size, null);
        }
}
}
