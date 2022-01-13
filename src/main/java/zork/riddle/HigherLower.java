package zork.riddle;

import java.util.Scanner;

public class HigherLower implements Riddle {
    private int rndmNumber;
    public boolean solved;
    Scanner scanner = new Scanner(System.in);

    @Override
    public void start() {
        System.out.println("Guess the number from 1 - 100");
        rndmNumber = (int) (100 * Math.random());
        riddle();
    }

    @Override
    public void riddle() {
        while(!solved) {
            int answer = scanner.nextInt();

            if(answer == rndmNumber){
                solved = true;
            } else if(rndmNumber < answer) {
                solved = false;
                System.out.println("The number is smaller");
            } else {
                solved = false;
                System.out.println("The number is larger");
            }
        }
        System.out.println("You solved the riddle");
    }
}
