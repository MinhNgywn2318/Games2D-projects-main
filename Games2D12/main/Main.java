package main;
import javax.swing.JFrame;

import picture.picture;
/*w window */
public class Main {
    public static void main(String[] args){
        JFrame w = new JFrame();
        picture p = new picture();
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setIconImage(p.get("icon"));
        w.setResizable(false);
        w.setTitle("My adventure");/*Set tittle */
        GamePanel gamePanel = new GamePanel();
        w.add(gamePanel);
        w.pack();
        w.setLocationRelativeTo(null);
        w.setVisible(true);
        gamePanel.startGameThread();
        gamePanel.setupGame();
    }
}