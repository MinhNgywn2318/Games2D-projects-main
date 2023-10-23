package main;
import object.SuperObject;
import object.object_set;
import sound.Sound;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import Events.SuperEvent;
import KeyBoard.KeyCommand;
import KeyBoard.keyControl;
import KeyBoard.playKey;
import KeyBoard.startKey;
import KeyBoard.pauseKey;

import TextSreen.announceState;
import TextSreen.playState;
import TextSreen.quizzState;
import TextSreen.Screens.pauseScreen;
import TextSreen.Screens.startScreen;
import tiles.TilesMangaer;


import entity.Player;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class GamePanel extends JPanel implements Runnable {
    public boolean detection = false;
    public boolean object_detection = true;
    public boolean end = false;
    final int originalTileSize = 16;
    final int scale = 3;
    private int temp;
    public final int tileSize = originalTileSize * scale; /* 48*48 */
    public final int maxScreenCol = 16;//16
    public final int maxScreenRow = 12;//12
    public final int screenWidth = tileSize * maxScreenCol;//768
    public final int screenHeight = tileSize * maxScreenRow;//576
    // world settings
    public final int maxWorldCol = 100;
    public final int maxWorldRow = 100;//56
    public final int worldWidth = maxWorldCol*tileSize;
    public final int worldHeight = maxWorldRow*tileSize;
    //gamestate
    public int gamestate;
    public final int playState = 1;
    public final int announceState = 2;
    public final int startState = 3;
    public final int quizzState = 4;
    public final int pauseState = 5;
    public final int announceState1 = 6;

    int FPS = 60;
    /** list of keyboard*/
    private KeyCommand startKey = new startKey(this);
    private KeyCommand playKey = new playKey(this);
    private KeyCommand pauseKey = new pauseKey(this);
    public keyControl keyBoard = new keyControl(this, startKey, playKey, pauseKey);
    Sound music = new Sound();
    Sound SoundEffect = new Sound();
    public boolean hit =true;
    public Thread gameThread;

    public Player player = Player.getInstance(this,keyBoard);
    
    public TilesMangaer tilesM = new TilesMangaer(this);
    public collisionCheck cCheck = new collisionCheck(this);
    public SuperEvent eventH  = new SuperEvent(this,player);
    //Superobject Gamepannel 
    /** Polymorphism */

    public SuperObject object[] = new SuperObject[50];
    public object_set  objects = new object_set(this);

    public map map = new map(this);
    public boolean playMusic = true;
    public quizzState quizz = new quizzState(this,keyBoard);
    public Graphics2D g2;
    playState play = new playState(this);
    public announceState announce = new announceState(this);
    public startScreen start = new startScreen(this);
    public pauseScreen pause = new pauseScreen(this);



    // Player start positions
    int playerX     = 100;
    int playerY     = 100;
    int playerSpeed = 5;

    public GamePanel() {
        // set Background
        this.setPreferredSize(new Dimension(16*48, 12*48));
        this.setBackground(new Color(70,120,80));/* getHSBColor() */ /* decode hex code */ /*Color.decode("#000000") */
        this.setDoubleBuffered(true);
        
        // Insert Keyboard:
        this.addKeyListener(keyBoard);
        this.setFocusable(true);
    
    }
    public void setupGame(){
        gamestate = startState;
        objects.setup();
        if(gamestate == playState){
            map.set();
        }


    }


    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();

    }
    private void FPS(){
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        while(gameThread!= null){
            currentTime = System.nanoTime();
            delta += (currentTime-lastTime)/drawInterval;
            timer += (currentTime-lastTime);
            lastTime = currentTime;
            if(delta>=1){
                update();
                repaint();
                delta--;
            }
            if(timer>=1000000000){
                timer = 0;
            }
        }
    }
    @Override
    public void run() {
        FPS();
    }
    /**  
    * Update class where update keyboard
    */    
    public void update() {
     player.update();
     quizz.update();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        this.g2 = g2;

        // ui1.drawScreen("2");
        // ui.draw(g2);
            //  //draw map
             if(gamestate == playState||gamestate==announceState||gamestate == quizzState||gamestate== announceState1){
                tilesM.draw(g2);
    
                //draw object
                for(int i = 0; i < object.length; i++){
                   if(object[i] != null){
                    object[i].draw(g2,this);
                   }
                }
                
                //draw player
                player.draw(g2);
                //draw UI
                quizz.draw(g2);
                play.draw(g2);
                announce.draw(g2);
                g2.dispose();   
             }
             else if(gamestate==startState){
                start.draw(g2);
             }
             else if(gamestate==pauseState){
                pause.draw(g2);
             }
    }
    public void playMusic(int number){
        music.setFile(number);
        music.play();
        music.loop();
    }
    public void playMusic(String name){
        music.setFile(name);
        music.play();
        music.loop();
    }
    public void stopMusic(){
        music.stop();
    }
    public void playSE(int number){
        SoundEffect.setFile(number);
        SoundEffect.play();
    }
    public void playSE(String name){
        SoundEffect.setFile(name);
        SoundEffect.play();
    }
    public void setGamestate(int gamestate) {
        this.gamestate = gamestate;
    }
    public int getGamestate(){
        return this.gamestate;
    }
}
