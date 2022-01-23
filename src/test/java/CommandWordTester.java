import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import zork.Command;
import zork.CommandWords;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CommandWordTester {
    Command command;
    Command commandUnknown;
    CommandWords commandWords;
    @BeforeEach
    public void init(){
        command = new Command("quit");
        commandUnknown = new Command("LOL");
        commandWords = new CommandWords();
    }

    @Test
    @DisplayName("Check if command exists")
    public void testCommandWords(){
        assertTrue(commandWords.isCommand(command.getCommandWord()));
        assertFalse(commandWords.isCommand(commandUnknown.getCommandWord()));
    }
}
