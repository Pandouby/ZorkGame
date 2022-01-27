import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import zork.Command;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommandTest {
    Command command;
    Command command3;
    Command command2;

    @BeforeEach
    public void init(){
        command = new Command("quit");
        command3 = new Command("nodfgaldsj");
        command2 = new Command("go", "east");
    }

    @Test
    @DisplayName("Test, command quit should be known")
    public void testQuit(){
        assertEquals(false, command.isUnknown());
    }

    @Test
    @DisplayName("Check if commands have second words")
    public void testHasSecondWord(){
        assertTrue(command.hasSecondWord() == false);
        assertTrue(command2.hasSecondWord() == true);
    }

}
