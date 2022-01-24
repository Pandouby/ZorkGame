package zork;

import zork.riddle.Riddle;
import java.util.Scanner;

public class Lock {
    private Riddle riddle;
    private Item key;
    private boolean locked;
    private Scanner keyBoard;

    public Lock(Riddle riddle, Scanner keyBoard) {
        this.keyBoard = keyBoard;
        this.riddle = riddle;
        locked = true;
    }

    public Lock(Item key) {
        this.key = key;
        locked = true;
    }

    public Riddle getRiddle() {
        return riddle;
    }

    public void setRiddle(Riddle riddle) {
        this.riddle = riddle;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public Boolean lockUnlock (Item key) {
        if(this.key == null) {
            if(riddle.start(this.keyBoard)){
                locked = !locked;
            }
        }else if(this.key.getName() == key.getName()){
            locked =! locked;
        }
        return locked;
    }
}
