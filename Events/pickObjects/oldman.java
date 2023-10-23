package Events.pickObjects;

import java.util.Random;

import Events.SuperEvent;

public class oldman {
    private int i;
    private String[] announces =new String [10];
    private Random random = new Random();

    public oldman() {
        setup();
    }
    public void set(pickObjects p,int index){
        if (index == 32) {
            if (!p.isHaveToothpaste()) {
                p.announce("I lost the toothpaste. Can you please find it ?");
            } else {
                if (SuperEvent.player.speed == 4) {
                    p.announce("Thank you. Have a nice day.");
                    p.gp.playSE("clear");
                    p.clear();
                }
                else if (SuperEvent.player.speed == 3) {
                    p.announce("Thank you. Here is spped power as gift");
                    p.ModeSpeed(1);
                    SuperEvent.gp.playSE("clear");
                    p.clear();
                }
                else if (SuperEvent.player.speed == 2&&SuperEvent.gp.object[30]!=null) {
                    p.announce("Thank you. Here is spped power as gift");
                    p.ModeSpeed(1);
                    SuperEvent.gp.playSE("clear");
                    p.clear();
                }
            }

        } else {
            if(SuperEvent.isMan){
                if(p.isFirst&&SuperEvent.gp.object[41]==null) {
                    p.announce("Hello, there is something in the lava");
                        p.Key2();
                        p.isFirst= false;
                }
                else if(!p.isFirst&&SuperEvent.gp.object[41]!=null) {
                    random();
                    p.announce(announces[i]);
                }
                else if(!SuperEvent.isDoll&&(p.Keys()==0||p.Keys()==1)&&p.gp.object[42]==null){
                    p.announce("You again. Here is your last key . \n I hope you do not lost it");
                    p.addKey();
                    SuperEvent.isMan = false;
                }
                else{
                    random();
                    p.announce(announces[i]);
                }
    

            }
            else{
                random();
                p.announce(announces[i]);
            }
        }
    }
    public void setup(){
        announces[0] = "It is a good day";
        announces[1] = "You should apply solid priciples";
        announces[2] = "Sometimes number 1 in this world is better";
        announces[3] = "OOP is very easy. Do you agree with me ?";
        announces[4] = "Here is a joke\nA man tells his doctor: “I’ m addicted to Twitter!” \n The doctor replies:“Sorry, I don’t follow you...” ";
    }
    public void random(){
        this.i = random.nextInt(5);
    }
    
}
