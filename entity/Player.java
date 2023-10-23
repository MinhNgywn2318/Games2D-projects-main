package entity;

import main.GamePanel;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import KeyBoard.keyControl;

public class Player extends Entity {
    choosePlayer chooseSprite = new choosePlayer();
    private boolean transfer = false;
    public int screenX;
    public int screenY;
    private int Key_count = 0;
    public boolean isMove = true;
    private String objectName;
    GamePanel gp;
    public keyControl keyBoard;
    public int global_index = 0;

    private static Player player = null;

    private Player(GamePanel gp, keyControl keyBoard) {
        this.gp = gp;
        this.keyBoard = keyBoard;
        DefultValues();
        setDefultValues();
    }

    public static synchronized Player getInstance(GamePanel gp, keyControl keyBoard) {
        if (player == null) {
            player = new Player(gp, keyBoard);
        }
        return player;
    }

    public void DefultValues() {
        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 10;
        solidArea.width = 32;
        solidArea.height = 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

    }

    public void setDefultValues() {
        worldX = gp.tileSize * 15;// 15
        worldY = gp.tileSize * 11;// 11
        speed = 3;
        direction = "down";
        transfer = true;

    }

    public void update() {
        gp.eventH.checkEvent(worldX, worldY);
        // keyBoard player

        if ((gp.gamestate == gp.announceState || gp.gamestate == gp.playState)) {
            if (keyControl.pPress == true) {
                gp.gamestate = gp.pauseState;
                gp.stopMusic();
            }
        }
        gp.eventH.switchPlayer.set(worldX, worldY);

        // movements
        if (isMove) {
            if (keyControl.downPress == true || keyControl.upPress == true || keyControl.rightPress
                    || keyControl.leftPress == true) {
                if (keyControl.upPress == true) {
                    direction = "up";
                } else if (keyControl.downPress == true) {
                    direction = "down";
                } else if (keyControl.rightPress == true) {
                    direction = "right";
                } else if (keyControl.leftPress == true) {
                    direction = "left";
                }
                // check collision

                gp.eventH.pickObjects();

                collisionEnabled = false;

                gp.cCheck.checkTile(this);

                // object collision

                spriteCounter++;
                // gp.eventH.checkEvent();
                // if collision
                if (collisionEnabled == false) {
                    if (direction == "up") {

                        worldY -= speed;
                    }
                    if (direction == "down") {
                        worldY += speed;
                    }
                    if (direction == "right") {
                        worldX += speed;
                    }
                    if (direction == "left") {
                        worldX -= speed;
                    }
                }
                if (spriteCounter > 5) {
                    if (spriteNum == 1) {
                        spriteNum = 2;
                    } else if (spriteNum == 2) {
                        spriteNum = 1;
                    }
                    spriteCounter = 0;
                }

            }
        }
    }

    public void draw(Graphics2D g) {
        BufferedImage images = chooseSprite.get_image(transfer, direction, spriteNum);
        g.drawImage(images, screenX, screenY, null);
    }

    public void setTransfer(boolean transfer) {
        this.transfer = transfer;
    }

    public boolean getTransfer() {
        return this.transfer;
    }

    public void setKey_count(int key_count) {
        Key_count = key_count;
    }

    public void reset() {
        // gp.tilesM.tile[2].collision = true;//water
        // gp.tilesM.tile[6].collision = false;//lava
        // worldX = gp.tileSize * 15;//15
        // worldY = gp.tileSize * 11;//11
        speed = 3;
        direction = "down";
        Key_count = 0;
        isMove = true;
        gp.gamestate = gp.playState;
        collisionEnabled = false;

    }

    // set get
    public int getKey_count() {
        return Key_count;
    }

    public String getObjectName() {
        return objectName;
    }

}
