package zork.riddle;

import java.util.Scanner;

public class HigherLower implements Riddle {
    private int rndmNumber;
    public boolean solved;

    @Override
    public boolean start() {
        System.out.println("Guess the number from 1 - 100");
        rndmNumber = (int) (100 * Math.random());
        return riddle();
    }

    @Override
    public boolean riddle() {
        Scanner scanner = new Scanner(System.in);
        while(!solved) {
            int answer = scanner.nextInt();

            if(answer == rndmNumber){
                solved = true;
                System.out.println("You solved the riddle");
            } else if(rndmNumber < answer) {
                solved = false;
                System.out.println("The number is smaller");
            } else {
                solved = false;
                System.out.println("The number is larger");
            }
        }
        scanner.close();
        return solved;
    }
}
