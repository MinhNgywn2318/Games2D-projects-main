package KeyBoard;

import java.awt.event.KeyEvent;

import main.GamePanel;

public class pauseKey implements KeyCommand {
    private GamePanel gp;
    public pauseKey(GamePanel gp) {
        this.gp = gp;
    }
    @Override
    public void keyPressed(int key_code) {
        if (!gp.pause.pause) {
            if (key_code == KeyEvent.VK_W || key_code == KeyEvent.VK_UP) {
                gp.pause.command--;
                if (gp.pause.command < 0) {
                    gp.pause.command = 3;
                }
            }
            if (key_code == KeyEvent.VK_S || key_code == KeyEvent.VK_DOWN) {
                gp.pause.command++;
                if (gp.pause.command > 3) {
                    gp.pause.command = 0;
                }
            }
            if (gp.pause.command == 0 && key_code == KeyEvent.VK_SPACE) {
                gp.setGamestate(gp.playState);/* //dk choi nhac lại khi chuyển vùng */
                gp.playMusic(0);
            } else if (key_code == KeyEvent.VK_SPACE) {
                gp.pause.drawSubScreen = true;
                gp.pause.pause = true;

            }
        } else if (key_code == KeyEvent.VK_SPACE && gp.pause.pause) {
            gp.pause.drawSubScreen = false;
            gp.pause.pause = false;
        }
        if (gp.pause.drawSubScreen) {
            if (gp.pause.command == 3 || gp.pause.command == 1) {
                if (key_code == KeyEvent.VK_Y) {
                    if (gp.pause.command == 3) {
                        System.exit(0);
                    } else {
                        gp.map.reset();
                        gp.setGamestate(gp.playState);
                        gp.pause.drawSubScreen = false;
                        gp.pause.command = 0;
                        gp.pause.pause = false;
                    }
                }
                if (key_code == KeyEvent.VK_N) {
                    gp.pause.command = 0;
                    gp.pause.drawSubScreen = false;
                    gp.pause.pause = false;
                }
            }

        }
    }

    public void keyReleased(int key_code) {
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
}
