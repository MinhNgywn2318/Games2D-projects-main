package TextSreen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import main.GamePanel;
import object.object_Key;
import picture.picture;


public class playState extends SuperUI{
    private int minute = 0;
    public  boolean timeStop = false;

    private double seconds;
    DecimalFormat dFormat = new DecimalFormat("0");
    public playState(GamePanel gp) {
        super(gp,g2);
    }
    public void draw(Graphics2D g2) { //
        SuperUI.g2 = g2;
        if(gp.gamestate == gp.playState){
            time();
            hasKey();
        }
    }
    public void hasKey(){
        Font font = new Font("Arial", Font.PLAIN, 40);
        object_Key key  = new object_Key();
        BufferedImage key_picture = key.image;
        g2.setFont(font);
        g2.setColor(Color.white);
        g2.drawImage(key_picture, gp.tileSize/2,gp.tileSize/2,gp.tileSize,gp.tileSize,null);
        g2.drawString("x " +gp.player.getKey_count(),74,65);// 74 65
    }
    public void time(){
        Font font = new Font("Arial", Font.PLAIN, 40);
        picture  p = new picture();

        g2.setColor(Color.white);
        g2.setFont(font);
        if(!timeStop){
            seconds += (double)1/60;
        }
        if(Double.compare(seconds,(double)59)==1){
                System.out.println("2");
                minute +=1;
                seconds = (double)0;
        }

        g2.drawString("Speed: "+ gp.player.speed,gp.screenWidth-200,48);
    
       

        text = minute+":"+dFormat.format(seconds);
        int place = LocateCenterText(text);
        g2.drawString(text, place, 65);
        update();


    }
    public void resetTime() {
        this.seconds = 0;
        this.minute =0;
    }
    public void update(){

        if(gp.keyBoard.pPress&&((gp.gamestate == gp.playState))){
            timeStop = true;
        }
        else if(gp.keyBoard.pPress&&gp.gamestate == gp.pauseState){
            timeStop = false;

    }
}}
    
