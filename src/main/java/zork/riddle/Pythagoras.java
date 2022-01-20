package zork.riddle;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Pythagoras implements Riddle{
    private boolean solved;
    private int sideA;
    private int sideC;


    @Override
    public boolean start() {
        sideA = 3;
        sideC = 5;
        System.out.println("Calculate the missing side of the right angled triangle Triangle");
        System.out.println("Side a -> " + sideA + " / side c -> " + sideC);
        solved = false;
        return riddle();
    }

    @Override
    public boolean riddle() {
        Scanner scanner = new Scanner(System.in);

        while(!solved){
            int answer = scanner.nextInt();

            if(answer == 4){
                solved = true;
                System.out.println("You solved the riddle");
            }else {
                System.out.println("Wrong answer, Try again");
            }
        }
        scanner.close();
        return solved;
    }
}
