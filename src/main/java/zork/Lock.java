package zork;

import zork.riddle.Riddle;

public class Lock {
    private Riddle riddle;
    private boolean locked;

    public Lock(Riddle riddle) {
        this.riddle = riddle;
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

    public Boolean lockUnlock () {
        if(locked){
            locked = false;
        }else {
            locked = true;
        }
        return locked;
    }
}
