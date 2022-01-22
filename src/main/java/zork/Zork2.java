package zork;

import java.util.Scanner;

public class Zork2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to zork\nname: ");
		Game zorkgame = new Game(scanner.nextLine());
		zorkgame.play();
	}

}



