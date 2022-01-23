package zork.riddle;

import java.util.Scanner;

public class QuadraticEquation implements Riddle {
    private boolean solved;
    private String question;

    @Override
    public boolean start(Scanner scanner) {
        System.out.println("What is x equalt to");
        System.out.println("x2^2 + x + 5");
        solved = false;
        return riddle(scanner);
    }

    @Override
    public boolean riddle(Scanner keyBoard) {
        while (!solved) {
            String answer = keyBoard.nextLine();
            if (answer.equals("there's no answer")) {
                solved = true;
                System.out.println("You solved the riddle");
                break;
            } else if (answer.equals("quit riddle")) {
                break;
            } else {
                System.out.println("This answer is wrong, try again");
            }
        }
        return solved;
    }
}
