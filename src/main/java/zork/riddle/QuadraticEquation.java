package zork.riddle;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Scanner;

public class QuadraticEquation implements Riddle{
    private boolean solved;
    private String question;

    @Override
    public boolean start() {
        System.out.println("What is x equalt to");
        System.out.println("x2^2 + x + 5");
        solved = false;
        return riddle();
    }

    @Override
    public boolean riddle() {
        Scanner scanner = new Scanner(System.in);
        while(!solved) {
            String answer = scanner.next();
            if(answer.equals("")) {
                solved = true;
                System.out.println("You solved the riddle");
            }else {
                System.out.println("This answer ist wrong, try again");
            }
        }
        scanner.close();
        return solved;
    }
}
