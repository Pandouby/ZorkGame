package zork;

import zork.rooms.Room;

public class Map {

    public static void map(Room currentRoom){
        System.out.println("You're in the: " + currentRoom.shortDescription());
    }
}
