package entity;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import main.tools;
import main.GamePanel;

public class choosePlayer {
   public choosePlayer() {
      this.getplayerImage();
   }
   GamePanel gp;
   public BufferedImage up11;
   public BufferedImage up12;
   public BufferedImage down11;
   public BufferedImage left12;
   public BufferedImage left11;
   public BufferedImage down12;
   public BufferedImage right11;
   public BufferedImage right12;
   public BufferedImage up21;
   public BufferedImage up22;
   public BufferedImage down21;
   public BufferedImage left22;
   public BufferedImage left21;
   public BufferedImage down22;
   public BufferedImage right21;
   public BufferedImage right22;

   private void getplayerImage() {
      //player 1
      up11 =setup("1_up_1");
      up12 = setup("1_up_2");
      down11 = setup("1_down_1");
      down12 = setup("1_down_2");
      left11 = setup("1_left_1");
      left12 = setup("1_left_2");
      right11 = setup("1_right_1");
      right12 = setup("1_right_2");
      // player2
      up21 = setup("2_up_1");
      up22 = setup("2_up_2");
      down21 = setup("2_down_1");
      down22 = setup("2_down_2");
      left21 = setup("2_left_1");
      left22 = setup("2_left_2");
      right21 = setup("2_right_1");
      right22 = setup("2_right_2");
   }
   public BufferedImage setup(String imageName) {
      tools Utool = new tools();
      BufferedImage image = null;
      try {
         image =  ImageIO.read(getClass().getResourceAsStream("/picture/players/"+ imageName +".png"));
         image = Utool.scaleImage(image,48,48);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return image;
   }


   public BufferedImage get_image(boolean transfer, String direction, int spritenumber) {
      if (transfer) {
         if (direction == "up") {
            if (spritenumber == 1) {
               return up21;
            }
            if (spritenumber == 2) {
               return up22;
            }
         } else if (direction == "down") {
            if (spritenumber == 1) {
               return down21;
            }
            if (spritenumber == 2) {
               return down22;
            }
         } else if (direction == "right") {
            if (spritenumber == 1) {
               return right21;
            }
            if (spritenumber == 2) {
               return right22;
            }
         } else if (direction == "left") {
            if (spritenumber == 1) {
               return left21;
            }
            if (spritenumber == 2) {
               return left22;
            }
         }
      } 
      else {
         if (direction == "up") {
            if (spritenumber == 1) {
               return up11;
            }
            if (spritenumber == 2) {
               return up12;
            }
         } else if (direction == "down") {
            if (spritenumber == 1) {
               return down11;
            }
            if (spritenumber == 2) {
               return down12;
            }
         } else if (direction == "right") {
            if (spritenumber == 1) {
               return right11;
            }
            if (spritenumber == 2) {
               return right12;
            }
         } else if (direction == "left") {
            if (spritenumber == 1) {
               return left11;
            }
            if (spritenumber == 2) {
               return left12;
            }
         }

      }
      return null;
   }
}
