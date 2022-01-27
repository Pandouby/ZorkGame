import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import zork.Enemy;
import zork.Fight;
import zork.Item;
import zork.Player;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

import static junit.framework.TestCase.*;

public class FightTester {
    Scanner keyBoard;
    Player player;
    Player toWeak;
    Enemy enemyWeak;
    Enemy toStrongEnemy;
    Item item;
    Item item2;
    Item item3;
    Item item4;
    Fight fightPlayer;
    Fight fight2;

    @BeforeEach
    public void init() throws IOException {
        //Scanner for input
        String inputMessage = "Sword\n"
                + "Sword\n"
                + "Sword\n"
                + "Sword\n"
                + "Sword\n"
                + "Sword";

        keyBoard = new Scanner(new ByteArrayInputStream(inputMessage.getBytes(StandardCharsets.UTF_8)));
        //Add Player
        player = new Player(100.0, new ArrayList<>(), "TestPlayer");
        toWeak = new Player(100.0, new ArrayList<>(), "TestPlayer");
        //Make Items
        item = new Item("Test Item", "Tester", 10, 20, 0.5);
        item2 = new Item("Key", "Tester", 10, 0, 1);
        item3 = new Item("Shield", "Shield", 30, 0, 0.1);
        item4 = new Item("Kill", "Sword", 10, 90, 0.7);
        Item itemForTheWeak = new Item("Kill but doesn't acutally", "Sword", 10, 0, 1);
        //Add enemy
        enemyWeak = new Enemy("GOBLINO", 100.0, 0.0, item);
        toStrongEnemy = new Enemy("El Dragon De la selva", 100.0, 90.0, item);
        //Add to Player class
        player.addToInventory(item);
        player.addToInventory(item2);
        player.addToInventory(item3);
        player.addToInventory(item4);

        toWeak.addToInventory(itemForTheWeak);

        //2 Fights, one enemy wins, one Player
        fightPlayer = new Fight(enemyWeak, player, keyBoard);
        fight2 = new Fight(toStrongEnemy, toWeak, keyBoard);

    }

    @Test
    @DisplayName("get highest percentage resistance")
    public void testGetResistance() {
        System.out.println(fightPlayer.getHighestResistance().getResistance());
        assertTrue(fightPlayer.getHighestResistance().getResistance() == 0.1);
    }

    @Test
    @DisplayName("test Fight, outcome should be Player wins")
    public void testFight() {
        assertTrue(fightPlayer.fight());
        assertEquals(100.0, fightPlayer.getPlayer().getHealth());
        assertEquals(-80.0, fightPlayer.getEnemy().getHealth());
    }


    @Test
    @DisplayName("test Fight, outcome should be Enemy wins")
    public void testEnemyFight(){
        assertTrue(!fight2.fight());
        assertEquals(-80.0, fight2.getPlayer().getHealth());
        assertEquals(100.0, fight2.getEnemy().getHealth());
    }

}
