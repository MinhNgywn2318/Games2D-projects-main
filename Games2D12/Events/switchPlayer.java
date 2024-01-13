package Events ;

import KeyBoard.keyControl;

public class switchPlayer extends SuperEvent{
    private SuperEvent event;
    public switchPlayer(SuperEvent events) {
        this.event = events;
    }
    private boolean checkPlace(int index) {
        switch (index) {
            case 1:
                // if (event.hit(61, 46,"up")||event.hit(42, 30,"up")) {
                //     return true;
                // }
                break;
            case 2:

              
                    
                break;
        }
        return false;

    }
/* need update code */
    public void setAnnouncement() {
        if (checkPlace(1)) {
            if (gp.player.getTransfer() == true) {
                announce("You can not pass lava. Please change character");
            } else if ( !gp.player.getTransfer() || keyControl.isSpace) {
                gp.setGamestate(gp.playState);
            }
        }
        else if (checkPlace(2)) {
            if (!gp.player.getTransfer()) {
            
                announce("You can not pass river. Please change character");

                // gp.setGamestate(gp.announceState);
            } else if (!gp.player.getTransfer() || keyControl.isSpace) {
                gp.setGamestate(gp.playState);
            }
        }

    }
    public void set(int worldX,int worldY){
        setAnnouncement();
        if (keyControl.isOne == true) {
            gp.player.setTransfer(false);
            gp.tilesM.tile[6].collision = true;
            gp.tilesM.tile[5].collision = false;
            //pruser to transfer when in lava
            // if (worldY > 319 && worldY < 560) {
            //     gp.player.setTransfer(true);
            //     gp.tilesM.tile[2].collision = false;
            // }
        }
        if (keyControl.isTwo == true) {
            gp.player.setTransfer(true);
            gp.tilesM.tile[6].collision = false;
            gp.tilesM.tile[5].collision = true;
                        //pruser to transfer when in pool
            // if (worldY > 560 && worldY < 848 && worldX > 1720) {
            //     gp.player.setTransfer(false);
            //     gp.tilesM.tile[6].collision = false;
            // }
        }
    }
}
