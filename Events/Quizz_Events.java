package Events;

public class Quizz_Events extends SuperEvent {
    private int x;
    private int y;
    public boolean teleport = false;

    public Quizz_Events() {
    }

    // public void ModeSpeed(int i){
    // announce("Speed up");
    // super.ModeSpeed(5);
    // }

    public void correct() {
        if (objectName == "question") {
            if (getObjectIndex() == 13 || getObjectIndex() == 14) {
                announce("Correct. Please choose a portal to pass");
                gp.playSE("clear");
                clear_object();
            } else {
                announce("Correct, you can pass");
                gp.playSE("unlock");

                clear_object();

            }
        }
        if (objectName == "NPC2") {
            announce("Correct. \nThere is something may help you in the North pool");
            Key1();
            isNPC2 = false;
        }
        if (objectName == "NPC3") {
            if (getObjectIndex() == 35) {
                announce("Very good. Maybe see you later");
                nextState(gp.playState);
                clear_object();
            } else {
                announce("Correct, you can pass me");
                nextState(gp.playState);
                clear_object();
            }
        }

    }

    public void wrong() {
        if (objectName == "question") {
            if (getObjectIndex() == 13 || getObjectIndex() == 14) {
                announce("Wrong. Here is a surprise for you");
                setTeleport(15, 81);
            } else {
                announce("Wrong, you can not pass");

            }
        } else if (objectName == "NPC2") {
            if (Keys() == 0) {
                announce("Wrong. Here is surprised for you");
                setTeleport(52, 29);
            }
            if (Keys() == 1) {
                announce("Wrong and go away. I will take your key as punish");
                loseKey();
                setTeleport(52, 29);
            }

        } else if (getObjectIndex() == 13 || getObjectIndex() == 14) {
            announce("Wrong.");
            setTeleport(15, 81);
        } else if (objectName == "NPC3") {
            if (getObjectIndex() == 35) {
                if (Keys() > 1 || (Keys() == 1 && (gp.object[31] != null || gp.object[29] != null))) {
                    announce("Wrong. You have a lot of keys, I will take your key.");
                    gp.playSE("clear");
                    nextState(gp.playState);
                    loseKey();
                    clear_object();
                    isNPC3 = false;

                } else if (Keys() == 0) {
                    if (player.speed == 4) {
                        announce("Wrong. Feel my  superpower....");
                        nextState(gp.playState);
                        setTeleport(22, 29);
                        ModeSpeed(-1);
                    }
                    if (player.speed == 3) {
                        announce("Wrong. Feel my power....");
                        nextState(gp.playState);
                        setTeleport(22, 29);
                    }
                }
            }

            else {
                announce("Wrong. You can not pass me. Here is your punish");
                setTeleport(44, 71);
                nextState(gp.playState);
            }
        }

    }

    public void teleport() {
        super.teleport(x, y, "right");
    }

    public void setTeleport(int x, int y) {
        this.x = x;
        this.y = y;
        teleport = true;
    }
}
