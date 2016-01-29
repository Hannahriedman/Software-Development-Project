
import java.util.Scanner;

/**
 * A text Adventure Murder Mystery game.
 * @author Hannah Riedman
 *
 */
public class HannahTextGame {
	
	// TODO add a static array variable to hold the local descriptions

	// TODO add a static int variable to keep track of player's current locale 

	// TODO add static variable(s) to hold player's custom info (name, etc.) 
		
	// TODO separate out some tasks (getting input, updating variable,
	//      displaying output) into their own functions and call those
	//      functions from within this main method
	
	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		
		String name;
		String gender;
		String direction;
		String userCommand;
		
		System.out.println("Murder Mystery Game!");
		System.out.println("********************\n");
		System.out.println("You arrive at the creepy mansion in the dark of night.\n"
							+ "There is a large door in front of you.");
		System.out.print("What is your character's name?");
		name = keyboard.nextLine();
		System.out.print("What is your character's gender?(m or f)");
		gender = keyboard.nextLine();
		
		System.out.print("Hello Detective " + name + "! You can navigate the game by using\n"
				+ "N,E,S,W commands. Go North to the door to start the adventure!");
		while (true) {
			
			System.out.print("Enter a command: ");
			userCommand = keyboard.nextLine();
			// TODO make input case insensitive 
			direction = ProcessDirection(userCommand);
			if (direction.equals(null)) {
				break;
			} else if (direction.equals("start over")) {
				continue;
			}
			//now "render" the game state by providing feedback to the player
			// TODO change this so that you print the description of the new location
			//System.out.println("You moved " + direction + ".\n");

		
		}

	}
	
	public static String ProcessDirection(String userCommand) {
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
			return null; // gets out of the game loop
		} else if (userCommand.equals("H")) {
			System.out.println("Use the commands N,E,S,W to go in the cardnial directions\n"
					+ "Type Q to quit the game.");
		} else {
			System.out.println("Invalid command!\n");
			return "start over"; 
		}
		
		return direction;
	}
		
		

}
