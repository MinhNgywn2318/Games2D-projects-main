package TextSreen.Screens;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Font;
import Font.Fonts;
import main.GamePanel;
import picture.picture;

public abstract class Screens {
    public static GamePanel gp;
    public static Graphics2D g2;
    public Fonts font = new Fonts();
    public picture pictures = new picture();

    public Screens(GamePanel gp,Graphics2D g2) 
    {
        Screens.gp = gp;
        Screens.g2 = g2;
    }
    public Screens(GamePanel gp){
        Screens.gp = gp;
    }
    public int LocateCenterText(String text) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth / 2 - length / 2;
        return x;
    }
       /**
    Teleport the player to some where in map
    @param mode = 0 :  instructions
    @param mode = 1 :  about
     */

    public void drawScreen(String text,int mode){
        int x = gp.tileSize *2;
        int y = gp.tileSize /2;
        int width = gp.screenWidth - (4*gp.tileSize);
        int height = (11*gp.tileSize);//11
        drawSubScreen(x, y, width, height);
        g2.setFont(font.getFont().deriveFont(Font.BOLD,20F));
        // x+= gp.tileSize;
        x = LocateCenterText(text);
        y+= gp.tileSize;
        g2.drawString(text, x, y);
        if(mode == 1){
            g2.drawImage(pictures.get("Instructions"),48*2+20,y+10,null);
        }
        else if(mode ==2){
            g2.drawImage(pictures.get("About"),48*2+20,y+10,null);
        }
        // g2.setColor(Color.black);
        // g2.drawRect(48*2+20,y+ 10,gp.screenWidth - (4*gp.tileSize)-40 , height-110);
        

        g2.drawString("press space to continue", width-150, height);
//536 418
    }
    public void drawSubScreen(int x, int y, int width, int height){
        // Color color = new Color(0,0,100,100);
        g2.setColor(Color.white);//nền trong
        g2.fillRoundRect(x, y,width ,height,35, 35);

        g2.setColor(Color.black);//viền
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5,width-10 ,height-10,25, 25);
}
public void drawScreen1(String text){
    int x = gp.tileSize *2;
    int y = gp.tileSize *3;
    int width = gp.screenWidth - (4*gp.tileSize);
    int height = (4*gp.tileSize);
    drawSubScreen(x, y, width, height);
    g2.setFont(g2.getFont().deriveFont(Font.BOLD,20F));
    x+= gp.tileSize;
    y+= gp.tileSize;
    g2.drawString(text, x, y);
    g2.drawString("(Y/N)", width, height+100);
}
    
}
