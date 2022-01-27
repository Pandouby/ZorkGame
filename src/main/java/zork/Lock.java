package zork;

import zork.riddle.Riddle;
import java.util.Scanner;

/**
 * @Author: Alex Smolders & Silvan Dubach
 * @Date: 27.01.22
 * @Version: 1.1
 *
 */

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

    public Lock(){
        locked = false;
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

    /**
     *
     * @param key from player invetory
     * @return if the door is unlocked
     */
    public Boolean lockUnlock (Item key) {
        if(this.key == null) {
            if(riddle.start(this.keyBoard)){
                locked = !locked;
            }
        }else if(this.key == key){
            locked =! locked;
        }
        return locked;
    }
}
