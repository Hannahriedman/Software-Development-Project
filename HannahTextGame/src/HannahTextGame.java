
import java.util.Scanner;

/**
 * A text Adventure Murder Mystery game.
 * @author Hannah Riedman
 *
 */
public class HannahTextGame {
	
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
			// primary game loop - updates the "game state"
			if (userCommand.equals("N")) { 
				direction = "North";
			} else if (userCommand.equals("E")) { 
				direction = "East";
			} else if (userCommand.equals("S")) { 
				direction = "South";
			} else if (userCommand.equals("W")) { 
				direction = "West";
			} else if (userCommand.equals("Q")) {
				break; // gets out of the game loop
			} else if (userCommand.equals("H")) {
				System.out.println("Use the commands N,E,S,W to go in the cardnial directions\n"
						+ "Type Q to quit the game.");
			} else {
				System.out.println("Invalid command!\n");
				continue; 
			}
			//now "render" the game state by providing feedback to the player
			// TODO change this so that you print the description of the new location
			//System.out.println("You moved " + direction + ".\n");

		
		}

	}

}
