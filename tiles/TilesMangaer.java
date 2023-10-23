package tiles;


import main.GamePanel;
import main.tools;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import KeyBoard.keyControl;

public class TilesMangaer extends Tiles {
    GamePanel gp;
    keyControl keyBoard;
    public Tiles[] tile;
    public int mapTileNumber[][];

    public TilesMangaer(GamePanel gp) {
        this.gp = gp;
        tile = new Tiles[20];
        mapTileNumber = new int[gp.maxWorldCol][gp.maxWorldRow];
        getImage();
        loadMap();
    }

    public void loadMap() {
        try {
            InputStream is = getClass().getResourceAsStream("/map/map.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int row = 0;
            int col = 0;
            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
                String line = br.readLine();
                while (col < gp.maxWorldCol) {
                    String number[] = line.split(" ");
                    int num = Integer.parseInt(number[col]);
                    mapTileNumber[col][row] = num;
                    col++;

                }
                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getImage() {
            setup(0,"0.grass", false);
            setup(1,"1.sand", false);
            setup(2,"2.earth", false);
            setup(3,"3.wall", true);
            setup(4,"4.tree", true);
            setup(5,"5.lava", true );
            setup(6,"6.water", false) ;//lava.collison =false;
            setup(7,"7.squid", true) ;//lava.collison =false;
            setup(8,"8.tree2", true);
            setup(9,"9.tree3", true);
            setup(10,"90.tree4", true);
            setup(11,"91.duck", true);
            

        }

    public void update() {

    }
    /** 
     @param index set index of tiles
     @param ImagePath name of the tiles
    @param IsCollison if it is true, player will mover the tiles, else player will not move to the tiles

     */
    public void setup(int index, String ImagePath, boolean IsCollision) {
        tools uTools = new tools();
        try {
            tile[index] = new Tiles();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/picture/tiles/"+ImagePath+".png"));
            tile[index].image = uTools.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = IsCollision;

            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void draw(Graphics2D g2) {
        // g2.drawImage(tiles[0].image,0,0,gp.tileSize,gp.tileSize,);
        int worldCol = 0;
        int worldRow = 0;
        int tileNumber = mapTileNumber[worldCol][worldRow];
        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
            tileNumber = mapTileNumber[worldCol][worldRow];
            int worldX = worldCol*gp.tileSize;
            int worldY = worldRow*gp.tileSize;
            int screenX = worldX -gp.player.worldX + gp.player.screenX;
            int screenY = worldY -gp.player.worldY + gp.player.screenY;
            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
            worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
            worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
            worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){
                g2.drawImage(tile[tileNumber].image, screenX, screenY, gp.tileSize, gp.tileSize, null);

            }
            worldCol++;
            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
