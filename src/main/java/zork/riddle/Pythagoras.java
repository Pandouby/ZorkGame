package zork.riddle;

import java.util.Scanner;

public class Pythagoras implements Riddle {
    private boolean solved;
    private int sideA;
    private int sideC;


    @Override
    public boolean start(Scanner scanner) {
        sideA = 3;
        sideC = 5;
        System.out.println("Calculate the missing side of the right angled triangle Triangle");
        System.out.println("Side a -> " + sideA + " / side c -> " + sideC);
        solved = false;
        return riddle(scanner);
    }

    @Override
    public boolean riddle(Scanner keyBoard) {
        while (!solved) {
            int answer = keyBoard.nextInt();

            if (answer == 4) {
                solved = true;
                System.out.println("You solved the riddle");
            } else if (String.valueOf(answer).equals("quit riddle")) {
                break;

            } else {
                System.out.println("Wrong answer, Try again");
            }
        }
        return solved;
    }
}
