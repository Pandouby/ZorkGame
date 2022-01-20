import org.junit.jupiter.api.BeforeEach;
import zork.Enemy;
import zork.Item;
import zork.Player;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class FightTester {
    Scanner keyBoard;
    Player player;
    Enemy enemy;
    Item item;

    @BeforeEach
    public void init(){
        keyBoard = new Scanner(new ByteArrayInputStream("Sword".getBytes(StandardCharsets.UTF_8)));
        player = new Player(100.0, new ArrayList<>(), "TestPlayer");
        item = new Item("Test Item", "Tester", 10, 20, 0.1);
        enemy = new Enemy("GOBLINO", 100.0, 30.0, item);
    }
}
