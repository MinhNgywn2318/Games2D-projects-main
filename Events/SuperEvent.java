package Events;

import java.awt.*;

import Events.pickObjects.pickObjects;
import KeyBoard.keyControl;
import entity.Player;
import main.GamePanel;
import object.object_Key;
import object.object_door;
import object.portal;

public class SuperEvent {
    public static GamePanel gp;
    public Rectangle eventRectangle;
    private int defultX, defultY;
    private boolean run = true;
    public static Player player;
    public static pickObjects getObjects;
    public boolean clear = false;
    protected static String objectName;
    public switchPlayer switchPlayer;
    public static int state = 1;
    public String text = " ";
    public static int next_state;
    public static int max_announce;
    public static String annouces[];
    public static boolean isDoll = true;
    public static boolean isMan = true;
    public static boolean isMonster = true;
    private int index = 0;
    public boolean isFirst = true;
    public static boolean teleport = false;
    public boolean closeDoor = false;

    public SuperEvent(GamePanel gp, Player player) {
        SuperEvent.gp = gp;
        SuperEvent.player = player;
        eventRectangle = new Rectangle();
        eventRectangle.x = 23;
        eventRectangle.y = 23;
        eventRectangle.width = 2;
        eventRectangle.height = 2;
        defultX = eventRectangle.x;
        defultY = eventRectangle.y;
        switchPlayer = new switchPlayer(this);
        getObjects = new pickObjects();
    }

    public static String getObjectName() {
        return objectName;
    }

    public SuperEvent(GamePanel gp) {
    }

    public void randomEvent() {

    }

    public SuperEvent() {
        super();
    }

    // *list of events */
    /**
     * Teleport the player to some where in map
     * 
     * @param x : locate X
     * @param y : locate Y
     */
    public void teleport(int x, int y) {
        gp.playSE("teleport");
        gp.player.worldX = x * gp.tileSize;
        gp.player.worldY = y * gp.tileSize;
        gp.player.direction = "up";
    }

    /**
     * Teleport the player to some where in map
     * 
     * @param x         : locate X
     * @param y         : locate Y
     * @param direction : "up","left","right","down"
     */
    public void teleport(int x, int y, String direction) {
        gp.playSE("teleport");
        gp.player.direction = direction;

        gp.player.worldX = x * gp.tileSize;
        gp.player.worldY = y * gp.tileSize;
    }

    public void pickObjects() {
        index = gp.cCheck.checkObject(player, true);
        if (index != -1) {
            objectName = gp.object[index].name;
            getObjects.set(objectName, index);
        }
    }

    /**
     * Modify player Sped
     * 
     * @param number > 0: increase speed
     * @param number < 0: decrease speed
     */
    public void ModeSpeed(int number) {
        gp.player.speed += number;
    }

    public void loseKey() {
        gp.player.setKey_count(gp.player.getKey_count() - 1);
    }

    public void addKey() {
        gp.player.setKey_count(gp.player.getKey_count() + 1);

    }

    // *Put in update */
    public void checkEvent(int worldX, int worldY) {
        musicEvent(51, 57, "squidGame", "road");
        // switchPlayer.set(worldX, worldY);
        // switchPlayer.set(player.worldX, player.worldY);
        if (keyControl.isSpace == true) {
            setState();
            System.out.println("x" + worldX / 48 + "y" + worldY / 48);

            System.out.println(getObjectIndex());

        }
        getObjects.nextTeleport();
        closeDoor();
    }

    public void musicEvent(int x, int y, String music_left, String music_right) {
        if (hit(58, 51, "left")) {
            System.out.println("2");
            gp.stopMusic();
            gp.playMusic(music_left);
            run = false;
        } else if (hit(58, 51, "right") && !run) {
            gp.stopMusic();
            gp.playMusic(music_right);
            run = true;
        }
    }

    public boolean hit(int eventCol, int eventRow, String direction) {
        boolean hit = false;
        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
        eventRectangle.x = eventCol * gp.tileSize + eventRectangle.x;
        eventRectangle.y = eventRow * gp.tileSize + eventRectangle.y;
        if (gp.player.solidArea.intersects(eventRectangle)) {
            if (gp.player.direction.contentEquals(direction)) {
                hit = true;
            }
        }
        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRectangle.x = defultX;
        eventRectangle.y = defultY;
        return hit;
    }

    /**
     * Add a object in the map
     * 
     * @param name : object name
     * @param x    : locate X
     * @param y:   locate Y
     */
    public void addObject(String name, int x, int y, int index) {
        if (name == "portal") {
            gp.object[index] = new portal();
            gp.object[index].worldX = x * gp.tileSize;
            gp.object[index].worldY = y * gp.tileSize;
        }
    }

    public void announce(String text) {
        gp.announce.text = text;
        gp.setGamestate(gp.announceState);
        gp.player.isMove = false;
    }

    public void continue_announce(String text) {
        this.text = text;
    }

    public void announce(String text, String sub_text) {
        gp.announce.text = text;
        gp.setGamestate(gp.announceState);
        gp.announce.sub_text = sub_text;
    }

    public void nextState(int states) {
        state = states;
    }

    public void setState() {
        gp.setGamestate(state);
        player.isMove = true;
    }

    public void clear_object() {
        getObjects.clear();
    }

    public int getObjectIndex() {
        return getObjects.getIndex();
    }

    public int Keys() {
        return player.getKey_count();
    }

    public void Key1() {
        gp.object[42] = new object_Key();
        gp.object[42].worldX = 60 * gp.tileSize;
        gp.object[42].worldY = 16 * gp.tileSize;
    }

    public void Key2() {
        gp.object[41] = new object_Key();
        gp.object[41].worldX = 62 * gp.tileSize;
        gp.object[41].worldY = 43 * gp.tileSize;
    }

    public void reset() {
        run = true;
        isDoll = true;
        getObjects.setHaveToothpaste(false);
        isMan = true;
        isFirst = true;
        closeDoor = false;
        isMonster = true;
    }

    public void closeDoor() {
        if (hit(53, 29, "right") && !closeDoor) {
            gp.object[34] = new object_door();
            gp.object[34].worldX = 50 * gp.tileSize;
            gp.object[34].worldY = 29 * gp.tileSize;
            gp.playSE("unlock");
            closeDoor = true;
        }

    }

}
