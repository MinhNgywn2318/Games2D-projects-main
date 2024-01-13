package KeyBoard;
import java.awt.event.KeyEvent;

import main.GamePanel;


public class startKey implements KeyCommand  {
    private GamePanel gp;
    public startKey(GamePanel gp) {
        this.gp = gp;
    }

    public void keyPressed(int key_code) {
        if (!gp.start.pause) {
            if (key_code == KeyEvent.VK_W || key_code == KeyEvent.VK_UP) {
                gp.start.command--;
                if (gp.start.command < 0) {
                    gp.start.command = 3;
                }
            }
            if (key_code == KeyEvent.VK_S || key_code == KeyEvent.VK_DOWN) {
                gp.start.command++;
                if (gp.start.command > 3) {
                    gp.start.command = 0;
                }
            }
            if (gp.start.command == 0 && key_code == KeyEvent.VK_SPACE) {
                gp.setGamestate(gp.playState);
                gp.playMusic("road");
            } else if (key_code == KeyEvent.VK_SPACE) {
                gp.start.drawSubScreen = true;
                gp.start.pause = true;

            }
        } else if (key_code == KeyEvent.VK_SPACE && gp.start.pause) {
            gp.start.drawSubScreen = false;
            gp.start.pause = false;
        }
        if (gp.start.drawSubScreen) {
            if (gp.start.command == 3) {
                if (key_code == KeyEvent.VK_Y) {
                    System.exit(0);
                }
                if (key_code == KeyEvent.VK_N) {
                    gp.start.command = 0;
                    gp.start.drawSubScreen = false;
                    gp.start.pause = false;
                }
            }

        }
    
    }


    public void keyReleased(int key_code) {
    }

   
    
}
