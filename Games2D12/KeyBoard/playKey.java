package KeyBoard;

import java.awt.event.KeyEvent;

import main.GamePanel;

public class playKey extends keyControl implements KeyCommand {
    private GamePanel gp;
    public playKey(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyPressed(int key_code) {
        if ((key_code == KeyEvent.VK_A || key_code == KeyEvent.VK_LEFT)&&(isSpace==false)) {
            leftPress = true;
        }
        else if ((key_code == KeyEvent.VK_D || key_code == KeyEvent.VK_RIGHT)&&(isSpace==false)) {
            rightPress = true;
        }
        else if (key_code == KeyEvent.VK_SPACE) {
            isSpace = true;
        }

        else if (key_code == KeyEvent.VK_1) {
            isOne = true;
        }
        else if (key_code == KeyEvent.VK_P) {
            pPress = true;
        }
        else if ((key_code == KeyEvent.VK_S || key_code == KeyEvent.VK_DOWN)) {
            downPress = true;

        }
        else if (key_code == KeyEvent.VK_W || key_code == KeyEvent.VK_UP) {
            upPress = true;
        }
        else if (key_code == KeyEvent.VK_2) {
            isTwo = true;
        }
       
    }

    @Override
    public void keyReleased(int key_code) {
        if (((key_code == KeyEvent.VK_A || key_code == KeyEvent.VK_LEFT))) {
            leftPress = false;
        }
        else if (key_code == KeyEvent.VK_P) {
            pPress = false;
        }
        else if ((key_code == KeyEvent.VK_D || key_code == KeyEvent.VK_RIGHT)) {
            rightPress = false;
        }
        else if (key_code == KeyEvent.VK_S || key_code == KeyEvent.VK_DOWN) {
            downPress = false;
        }
        else if (key_code == KeyEvent.VK_W || key_code == KeyEvent.VK_UP) {
            upPress = false;
        }
        else if (key_code == KeyEvent.VK_2) {
            isTwo = false;
        }
        else if (key_code == KeyEvent.VK_1) {
            isOne = false;
        }
        else if (key_code == KeyEvent.VK_SPACE) {
            isSpace = false;
        }
        else if (key_code == KeyEvent.VK_F) {
            fPress = false;
        }
        else  if (key_code == KeyEvent.VK_T) {
            tPress = false;
        }
    }
    
}
