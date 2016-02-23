
/**
 * CMPT 220L 114
 * Project 1
 * Date created: 1-29-16
 */
import java.util.Scanner;

/**
 * A text Adventure Murder Mystery game.
 * @author Hannah Riedman
 *
 */
public class HannahTextGame {
	
	static String [] descriptions={  // Array to hold descriptions for locations
			"You arrive at the creepy mansion in the dark of night.\n"
			+ "There is a large door in front of you.", // outside 0
			"You are now in the Foyer. There is a study to the East and sitting room\n"
			+ "to the West.", // Foyer 1
			"You are now in the Study. To the North is a door.", // Study 2
			"You are now in the sitting room.", // sitting room 3
			"You are now in the Library", // library 4		
			"You have found a secret stairway after leaning on the bookcase." // secret stairway 5
	};
	
	
	static int location = 0; // static variable declarations 
	static String name;
	static String gender;
	
	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		
		String direction;  // variable declarations 
		String userCommand;
		
		System.out.println("Murder Mystery Game!");  // intro and character customization
		System.out.println("********************\n");
		System.out.print("What is your character's name?");
		name = keyboard.nextLine();
		System.out.print("What is your character's gender?(m or f)");
		gender = keyboard.nextLine();
		
		System.out.println(descriptions[0]);  // start of game
		System.out.println("*************************************");
		System.out.println("Hello Detective " + name + "! You can navigate the game by using\n"
				+ "N,E,S,W commands. Go North to the door to start the adventure!");
		
		while (true) {
			
			System.out.print("Enter a command: ");
			userCommand = keyboard.nextLine();
			userCommand = userCommand.toUpperCase(); // makes input case sensititive.
	
			direction = processDirection(userCommand); // changes input into directions/commands
		
			if (direction.equals("quit")) {  // checks to see if you want to start over or quit
				break;  // quits game
			} else if (direction.equals("start over")) {
				continue; // starts loop over 
			}
			
			navigation(direction); // takes direction input and changes location   

		
		}
		
		System.out.println("Thanks For Playing " + name + " !\n");
		System.out.println("Creater: Hannah Riedman\n Copyright Hannah Games 2016");

		 
		keyboard.close();

	}
	
	public static String processDirection(String userCommand) {
		String direction = null;
		
		if (userCommand.equals("N")) { 
			direction = "North";
		} else if (userCommand.equals("E")) { 
			direction = "East";
		} else if (userCommand.equals("S")) { 
			direction = "South";
		} else if (userCommand.equals("W")) { 
			direction = "West";
		} else if (userCommand.equals("Q")) {
			return "quit"; // gets out of the game loop
		} else if (userCommand.equals("H")) {
			System.out.println("Use the commands N,E,S,W to go in the cardnial directions\n"
					+ "Type Q to quit the game.");
			return "start over";
		} else {
			System.out.println("Invalid command!\n");
			return "start over"; 
		}
		
		return direction;
	}
	
	public static int processLocation(int location) {

		// this method takes the location and displays the description 
		
		System.out.println(descriptions[location]);
		return location;
		
	}
		
	public static void navigation (String direction) {
		
		// this method takes direction and changes location and displays description
		
		if (direction.equals("North")) {
			if (location == 0) {
				location = processLocation(1);
			} else if (location == 1 || location == 3 || location == 4 || location == 5){
				System.out.print("You can not go North.");
			} else if (location == 2) {
				location = processLocation(4);
			} 
		} else if (direction.equals("East")) {
			if (location == 1) {
				location = processLocation(2);
			} else if (location == 0 || location == 2 || location == 4){
				System.out.print("You can not go East.");
			} else if (location == 3) {
				System.out.print(descriptions[1]); 
				location = 1;
			} else if (location == 5) {
				location = processLocation(4);
			}
		} else if (direction.equals("South")) {
			if (location == 1) {
				System.out.print("It would not be a good idea to go back outside"); 
			} else if (location == 0 || location == 2 || location == 3 ){
				System.out.print("You can not go South.");
			} else if (location == 4) {
				location = processLocation(2);
			}
		} else if (direction.equals("West")) {
			if (location == 1) {
				location = processLocation(3);
			} else if (location == 0 || location == 3 || location == 5){
				System.out.print("You can not go West.");
			} else if (location == 2) {
				location = processLocation(1);
			} else if (location == 4) {
				location = processLocation(5);
			}
		}
	}
}
