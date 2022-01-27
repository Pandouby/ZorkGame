import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zork.Door;
import zork.Enemy;
import zork.Item;
import zork.rooms.Room;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RoomTest {
    Room room1, room2;

    @BeforeEach
    public void init() {
        room1 = new Room("room1", "test");
        room2 = new Room("room2", "test");

        Door door = new Door(room1, room2);

        room1.setExits(null, null, door, null);
        room2.setExits(door, null, null, null);
    }

    @Test
    public void testNextRoom() {
        assertEquals(room2, room1.nextRoom("south"));
    }

    @Test
    public void testAddItem() {
        Item item = new Item("Test item", "test", 1, 0, 0);

        room1.addItem(item);
        assertTrue(room1.itemExists());

        room1.removeItem(item);
        assertFalse(room1.itemExists());
    }

    @Test
    public void testAddEnemy(){
        Enemy enemy = new Enemy("test", 100, 30, null);
        room1.setEnemy(enemy);
        assertTrue(room1.enemyExists());
    }
}
