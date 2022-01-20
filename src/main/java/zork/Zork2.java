package zork;

import zork.riddle.QuadraticEquation;
import zork.riddle.Riddle;
import zork.rooms.Room;

import java.util.Scanner;

public class Zork2 {

	public static void main(String[] args) {
		/*
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to zork\n name: ");
		Game zorkgame = new Game(scanner.nextLine());
		zorkgame.play();*/

		Riddle riddle = new QuadraticEquation();

		riddle.start();
	}

}



