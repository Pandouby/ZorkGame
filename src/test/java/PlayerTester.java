import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import zork.Item;
import zork.Player;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static junit.framework.TestCase.*;

public class PlayerTester {
    Player player;
    Item item;
    Item itemToHeavy;
    Item item3;

    @BeforeEach
    public void init() {
        player = new Player(100, new ArrayList<>(), "testDummy1");
        item = new Item("TestItem", "Key", 1, 1, 0);
        itemToHeavy = new Item("TestItem", "Key to kitchen", 200, 1, 0);
        item3 = new Item("Sword to fight", "Sword", 1, 30, 0);
    }

    @Test
    @DisplayName("adding Items")
    public void testAddItems() {
        assertTrue(player.addToInventory(item));
        assertTrue(player.getWeight() == 2);
        assertTrue(player.getInventory().size() == 2);
        assertFalse(player.addToInventory(itemToHeavy));
        assertEquals(2.0, player.getWeight());
    }

    @Test
    @DisplayName("removing Items")
    public void removeItem() {
        player.addToInventory(item);
        player.dropItem(item);
        assertEquals(3.0, player.getWeight());
        assertTrue(player.getInventory().size() == 1);
        player.listItems();
    }

    @Test
    @DisplayName("check if item exists in Inventory")
    public void check(){
        player.addToInventory(item3);
        player.listItems();
        assertEquals("Sword", player.checkIfItemExists("sword").getName());
        assertEquals(null, player.checkIfItemExists("Random"));
    }
}
