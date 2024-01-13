package TextSreen.Screens;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import Font.Fonts;
import TextSreen.UI_interface;
import entity.choosePlayer;
import main.GamePanel;

public class pauseScreen extends Screens{
  
    public choosePlayer playerImage = new choosePlayer();
    public int command;
    public boolean drawSubScreen;
    public boolean pause;
    public Fonts font = new Fonts();

  
    public pauseScreen(GamePanel gp) {

        super(gp,g2);
    }
    private String screen_text;

 
    public void draw(Graphics2D g2) {
        this.g2 = g2;
        if(drawSubScreen){
            if(command == 3||command == 1){
                drawScreen1(screen_text);
            }else{
                drawScreen(screen_text,command-1);
                pause =true;         
            }
        }
        else{
            g2.setFont(font.getFont().deriveFont(Font.BOLD, 96F));
            String text = "Pause Menu";
            int x = LocateCenterText(text);
            int y = gp.tileSize * 3;
            g2.setColor(new Color(69, 69, 69));
            g2.drawString(text, x + 4, y + 4);// draw shadow
            g2.setColor(Color.WHITE);
            g2.drawString(text, x, y);
            // draw image
            // g2.drawLine(gp.screenWidth / 2, 0, gp.screenWidth / 2, gp.screenHeight);
            x = (gp.screenWidth / 2) - 2 * gp.tileSize;
            y += gp.tileSize;
            //
            g2.drawImage(playerImage.get_image(true, "down", 1), x, y, gp.tileSize * 2, gp.tileSize * 2, null);
            x += 2 * gp.tileSize + 5;
            //
            g2.drawImage(playerImage.get_image(false, "down", 2), x, y, gp.tileSize * 2, gp.tileSize * 2, null);
            menu(g2, x, y);
        }
    }
   

    private void menu(Graphics2D g2, int x, int y) {
        g2.setFont(font.getFont().deriveFont(Font.BOLD, 48F));
        String text = "RESUME";
        x = LocateCenterText(text);
        y += gp.tileSize * 3.5;
        g2.drawString(text, x, y);
        if(command == 0){
                   g2.drawString(">", x - gp.tileSize, y);
                   g2.drawString("<", x + 3*gp.tileSize, y);

        }

        text = "RESTART";
        x = LocateCenterText(text);
        y += gp.tileSize;
        if(command == 1){
                   g2.drawString(">", x - gp.tileSize, y);
                   g2.drawString("<", x + 3*gp.tileSize, y);
                   screen_text = "Are you sure want to restart the game?";
                }


        g2.drawString(text, x, y);

        text = "INSTRUCTIONS";
        x = LocateCenterText(text);
        y +=gp.tileSize;
        g2.drawString(text, x, y);
        if(command == 2){
                   g2.drawString(">", x - gp.tileSize, y);
                   g2.drawString("<", x +5*gp.tileSize, y);
                    screen_text = "instructions";
        }
        text = "QUIT";
        x = LocateCenterText(text);
        y +=gp.tileSize;
        g2.drawString(text, x, y);
        if(command == 3){
                   g2.drawString(">", x - gp.tileSize, y);
                   g2.drawString("<", x +2*gp.tileSize, y);
                   screen_text = "Are you sure want to quit?";
        }
    }
    }

   