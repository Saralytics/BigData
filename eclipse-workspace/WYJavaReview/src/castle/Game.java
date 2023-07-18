package castle;

import java.util.Scanner;

public class Game {
	private Room currentRoom;
	
	public Game() {
		createRooms();
	}
	
	private void createRooms() {
		Room outside, lobby, pub, study, bedroom;
		
		// Initialize rooms 
		outside = new Room("Outside");
		lobby = new Room("Lobby");
		pub = new Room("Pub");
		study = new Room("Study");
		bedroom = new Room("Bedroom");
		
		// Set exits for each room 
		
		outside.setExit("east",pub);
		outside.setExit("south",lobby);
		outside.setExit("west", study);
		lobby.setExit("west", study);
		study.setExit("south", outside);
		study.setExit("up", bedroom);
		bedroom.setExit("down",study);
		
		// Always start from outside 
		currentRoom = outside;
		
	}

	private void printWelcome() {
		System.out.println();
		System.out.println("Welcome to this boring game");
		System.out.println("Type help if you need help ");
		System.out.println();
		System.out.print(currentRoom.getExitDesc());
		
	}
	
	private void printHelp() {
		System.out.print("Lost? You can use command: go, bye, help");
		System.out.println("For example: go east");
	}
	
	private void goRoom(String direction) {
		Room nextRoom = currentRoom.goToExit(direction);
		
		if (nextRoom == null) {
			System.out.println("There's no door ");
		}
		else {
			currentRoom = nextRoom;
			System.out.print(currentRoom.getExitDesc());
		}
	}
	
	
	public static void main(String[] args) {
		// Game intro and welcome
		
		Scanner in = new Scanner(System.in);
		Game game = new Game();
		game.printWelcome();
		
		while(true) {
			String line = in.nextLine();
			String[] words = line.split(" ");
			if(words[0].equals("help")) {
				game.printHelp();
			} else if(words[0].equals("go")) {
				game.goRoom(words[1]);
			} else if(words[0].equals("bye")) {
				break;
			}
		}

		System.out.println("Thank you for visiting, good bye.");
		in.close();
		
	}

}
