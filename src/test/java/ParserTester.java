import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import zork.Command;
import zork.Parser;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;


public class ParserTester {
    Parser parser;
    Scanner keyBoard;

    @BeforeEach
    public void init(){
        String inputs = "quit\n"
                + "drop item\n"
                + "fsdfjs";

        keyBoard = new Scanner(new ByteArrayInputStream(inputs.getBytes(StandardCharsets.UTF_8)));
        parser = new Parser(keyBoard);
    }

    @Test
    @DisplayName("testing if quit exists")
    public void testInputSingle(){
        Command command = parser.getCommand();
        assertEquals("quit", command.getCommandWord());
    }

    @Test
    @DisplayName("test if two arguments exist")
    public void testInputDouble(){
        parser.getCommand();
        Command command = parser.getCommand();
        assertEquals(true, command.hasSecondWord());
    }

    @Test
    @DisplayName("check if invalid returns null")
    public void testInputInvalid(){
        parser.getCommand();
        parser.getCommand();
        Command command = parser.getCommand();
        assertEquals(null, command.getCommandWord());
        assertEquals(false, command.hasSecondWord());
    }
}
