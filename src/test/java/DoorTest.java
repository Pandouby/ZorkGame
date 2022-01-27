import org.junit.jupiter.api.Test;
import zork.Door;
import zork.rooms.Room;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoorTest {

    @Test
    public void testGetOtherRoom() {
        Room room1 = new Room("Test", "Test");
        Room room2 = new Room("Test", "Test");
        Door door = new Door(room1, room2);

        assertEquals(room2, door.getOtherRoom(room1));
        assertEquals(room1, door.getOtherRoom(room2));
    }
}
