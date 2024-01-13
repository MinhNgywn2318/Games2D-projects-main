package TextSreen;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import Font.Fonts;

import main.GamePanel;

public abstract class SuperUI {
    public static Graphics2D g2;
    public static GamePanel gp;
    public String sub_text = " ";
    public String text = " ";
    public int word_length;
    public Fonts font = new Fonts();

    public void drawSubScreen(int x, int y, int width, int height) {
        g2.setFont(new Font("Arial", Font.ITALIC, 30));
        Color color = new Color(0, 0, 0,200);
        g2.setColor(color);// nền trong
        g2.fillRoundRect(x, y, width, height, 35, 35);
        g2.setColor(Color.white);// viền
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);
    }

    public int LocateCenterText(String text) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth / 2 - length / 2;
        return x;
    }

    public SuperUI(GamePanel gp, Graphics2D g2) {
        SuperUI.gp = gp;
        SuperUI.g2 = g2;
    }

    public SuperUI(GamePanel gp) {
    }

    public void drawScreen() {
        int x = gp.tileSize * 2;
        int y = gp.tileSize / 2;
        int width = gp.screenWidth - (4 * gp.tileSize);
        int height = (4 * gp.tileSize);
        drawSubScreen(x, y, width, height);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 18F));
        x += gp.tileSize;
        y += gp.tileSize;
        // g2.drawString(this.text, x, y);
        for(String line  :text.split("\n")){
            g2.drawString(line,x,y);
            y+=40;
        }
        g2.drawString(this.sub_text, width - 130, height);
    }

    public void drawScreen(String text) {
        int x = gp.tileSize * 2;
        int y = gp.tileSize / 2;
        int width = gp.screenWidth - (4 * gp.tileSize);
        int height = (4 * gp.tileSize);
        drawSubScreen(x, y, width, height);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 18F));
        x += gp.tileSize;
        y += gp.tileSize;
        for(String line :text.split("\n")){
            g2.drawString(line,x,y);
            y+=40;
        }
        // g2.drawString(text, x, y);
        g2.drawString(this.sub_text, width - word_length, height);
    }

}
