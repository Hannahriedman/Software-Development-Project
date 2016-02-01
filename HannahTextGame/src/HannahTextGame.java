
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
	
	static String [] descriptions={
			"You arrive at the creepy mansion in the dark of night.\n "
			+ "There is a large door in front of you.", // outside 0
			"You are now in the Foyer. There is a study to the East and sitting room\n"
			+ "to the West.", // Foyer 1
			"You are now in the Study. To the North is a door.", // Study 2
			"You are now in the sitting room.", // sitting room 3
			"You are now in the Library" // library 4		
	};
	
	static int location = 0;
	
	static String name;
	static String gender;
		
	// TODO separate out some tasks (getting input, updating variable,
	//      displaying output) into their own functions and call those
	//      functions from within this main method
	
	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		
		String direction;
		String userCommand;
		
		System.out.println("Murder Mystery Game!");
		System.out.println("********************\n");
		System.out.println(descriptions[0]);
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
			if (direction.equals("North")) {
				if (location == 0) {
					System.out.print(descriptions[1]);
					location = 1;
				} else if (location == 1 || location == 3 || location == 4){
					System.out.print("You can not go North.");
				} else if (location == 2) {
					System.out.print(descriptions[4]);
				}
			} else if (direction.equals("East")) {
				
			} else if (direction.equals("South")) {
				
			} else if (direction.equals("West")) {
				
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
