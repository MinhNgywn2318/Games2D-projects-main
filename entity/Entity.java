package entity;
import java.awt.Rectangle;

public class Entity {
    public int worldX;
    public int worldY;
    public int speed;
    public String direction = " ";
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea;
    public boolean collisionEnabled = false;
    public int solidAreaDefaultX,solidAreaDefaultY;
    String announcements[] = new String[20];
    public void announce() {}

}   