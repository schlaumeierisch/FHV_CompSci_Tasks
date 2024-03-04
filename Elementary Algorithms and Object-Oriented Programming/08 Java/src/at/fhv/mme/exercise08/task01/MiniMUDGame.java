package at.fhv.mme.exercise08.task01;

import java.util.Scanner;

/**
 * Mini-MUD Game (Exercise 08)
 * 
 * @author	Matthias Meier
 * @date	2021-06-15
 */
public class MiniMUDGame {
	public static void main(String[] args) {
	Game game = new Game();
	boolean gameRunning = true;
	
	Scanner scanner = new Scanner(System.in);
	game.showIntro();
	
	
	while (gameRunning == true) {
		String enteredCommand = scanner.nextLine();
		String[] splittedCommands = enteredCommand.split(" ");
		int commandsCount = splittedCommands.length;
		
		if (commandsCount == 1) {
			if (splittedCommands[0].equals("inspect")) {
				((Field) game.getMap().get(game.getPlayer().getField().getId())).availableItems();
			} else if (splittedCommands[0].equals("commands")) {
				game.showCommands();
			} else if (splittedCommands[0].equals("map")) {
				game.playersCurrentPosition();
			} else if (splittedCommands[0].equals("quit")) {
				System.out.println("You have successfully left the game.");
				gameRunning = false;
			} else if (splittedCommands[0].equals("inventory")) {
				game.getPlayer().printInventory();
			} else {
				System.out.println("Invalid command. Please re-enter the command.");
			}
		} else if (commandsCount == 2) {
			if (splittedCommands[0].equals("move")) {
				game.playerMovesTo(splittedCommands[1]);
			} else if (splittedCommands[0].equals("take")) {
				game.playerTakesItem(splittedCommands[1]);
			} else if (splittedCommands[0].equals("consume")) {
				game.playerConsumesItem(splittedCommands[1]);
			} else if (splittedCommands[0].equals("place")) {
				game.getPlayer().placeItem(splittedCommands[1]);
			} else {
				System.out.println("Invalid command. Please re-enter the command.");
			}
		} else {
			System.out.println("Invalid command. Please re-enter the command.");
		}
	}
	
	scanner.close();
	}
}