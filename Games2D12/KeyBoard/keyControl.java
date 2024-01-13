package KeyBoard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.GamePanel;

public class keyControl implements KeyListener {
    public static boolean upPress, downPress, rightPress, leftPress,isSpace;
    public static boolean tPress, fPress;
    public boolean isFall;
    public static boolean isOne, isTwo;
    public static boolean pPress;
    protected static GamePanel gp;
    private KeyCommand startState, pauseState, playState;

    public keyControl(GamePanel gp,KeyCommand startState,KeyCommand playState, KeyCommand pauseState ) {
        keyControl.gp = gp;
        this.startState = startState;
        this.playState = playState;
        this.pauseState = pauseState;
    }
    public keyControl() {
        super();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key_code = e.getKeyCode();

        if (gp.gamestate == gp.startState) {
            startState.keyPressed(key_code);
        } else if (gp.gamestate == gp.pauseState) {
            pauseState.keyPressed(key_code);
        } else if (gp.gamestate == gp.playState || gp.gamestate == gp.announceState||gp.gamestate == gp.announceState1) {
            playState.keyPressed(key_code);

        } else if (gp.gamestate == gp.quizzState) {
            if (key_code == KeyEvent.VK_F) {
                fPress = true;
            }
            if (key_code == KeyEvent.VK_T) {
                tPress = true;
            }
            if(key_code == KeyEvent.VK_SPACE) {
                isSpace = true;
            }

    }}

    @Override
    public void keyReleased(KeyEvent e) {
        int key_code = e.getKeyCode();
        playState.keyReleased(key_code);

    }

    public void startState(int key_code) {
    }

}
