package zork;

import zork.riddle.Riddle;

public class Lock {
    private Riddle riddle;
    private Item key;
    private boolean locked;

    public Lock(Riddle riddle) {
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
            if(riddle.start()){
                locked = !locked;
            };
        }else if(this.key == key){
            locked =! locked;
        }
        return locked;
    }
}