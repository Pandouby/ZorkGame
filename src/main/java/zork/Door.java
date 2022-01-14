package zork;

import zork.rooms.Room;

public class Door {
    private Room room1;
    private Room room2;
    private Lock lock;

    public Room getOtherRoom(Room room) {
        if(room == room1){
            return room2;
        }else {
            return  room1;
        }
    }
}
