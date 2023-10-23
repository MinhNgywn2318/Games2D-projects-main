package TextSreen;

import java.awt.Graphics2D;

import Events.SuperEvent;
import main.GamePanel;

public class announceState extends SuperUI{
    public boolean getKey = false;
    public announceState(GamePanel gp) {
        super(gp,g2);
        sub_text = "Press space to continue";
        word_length = 150;
        
    }
    public void draw(Graphics2D g2) { //
        SuperUI.g2 = g2;
        if(gp.gamestate == gp.announceState||gp.gamestate == gp.announceState1){
            drawScreen();
            if(SuperEvent.getObjectName()=="key"&&gp.eventH.getObjectIndex()!=37&&gp.eventH.getObjectIndex()!=23){
                g2.drawString("+1 key", gp.player.screenX+40, gp.player.screenY);
            }
        }
        
    }
}
