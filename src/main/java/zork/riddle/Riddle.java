package zork.riddle;

import zork.CommandWords;

import java.util.Scanner;

public interface Riddle {

    public CommandWords commands = new CommandWords();

    public boolean start(Scanner scanner);
    public boolean riddle(Scanner scanner);
}
