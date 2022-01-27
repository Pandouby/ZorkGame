import org.junit.jupiter.api.BeforeEach;
import zork.Parser;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ParserTester {
    Parser parser;
    Scanner keyBoard;

    @BeforeEach
    public void init(){
        String inputs = "Sword\n"
                + "Sword\n"
                + "Sword\n"
                + "Sword\n"
                + "Sword\n"
                + "Sword";
        keyBoard = new Scanner(new ByteArrayInputStream(inputs.getBytes(StandardCharsets.UTF_8)));
        parser = new Parser(keyBoard);
    }
}
