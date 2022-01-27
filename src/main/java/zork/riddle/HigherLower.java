package zork.riddle;

import java.util.Scanner;

public class HigherLower implements Riddle {
    private int rndmNumber;
    public boolean solved;

    @Override
    public boolean start(Scanner keyboard) {
        System.out.println("Guess the number from 1 - 100");
        rndmNumber = (int) (100 * Math.random());
        return riddle(keyboard);
    }

    @Override
    public boolean riddle(Scanner keyboard) {
        while (!solved) {
            String answer = keyboard.nextLine();

            if (Integer.valueOf(answer) == rndmNumber) {
                solved = true;
                System.out.println("You solved the riddle");
            } else if (rndmNumber < Integer.valueOf(answer)) {
                solved = false;
                System.out.println("The number is smaller");
            } else if (answer.equals("quit riddle")) {
                break;

            } else {
                solved = false;
                System.out.println("The number is larger");
            }
        }
        return solved;
    }
}
