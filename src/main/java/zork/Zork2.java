package zork;

import java.io.IOException;
import java.util.Scanner;

public class Zork2 {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to zork\nname: ");
		Game zorkgame = new Game(scanner.nextLine());
		zorkgame.play();
	}

}



