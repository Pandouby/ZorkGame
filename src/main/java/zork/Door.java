package zork;

import zork.rooms.Room;

/**
 * @Author: Alex Smolders & Silvan Dubach
 * @Date: 27.01.22
 * @Version: 1.1
 *
 */
public class Door {
    private Room room1;
    private Room room2;
    private Lock lock;

    public Door(Room room1, Room room2, Lock lock) {
        this.room1 = room1;
        this.room2 = room2;
        this.lock = lock;
    }

    public Door(Room room1, Room room2) {
        this(room1, room2, null);
    }

    /**
     *
     * @param current room
     * @return other room connected to door
     */
    public Room getOtherRoom(Room room) {
        if(room == room1){
            return room2;
        }else {
            return  room1;
        }
    }

    public Room getRoom1() {
        return room1;
    }

    public void setRoom1(Room room1) {
        this.room1 = room1;
    }

    public Room getRoom2() {
        return room2;
    }

    public void setRoom2(Room room2) {
        this.room2 = room2;
    }

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    public boolean unlockDoor(Item key) {
        return lock.lockUnlock(key);
    }
}
