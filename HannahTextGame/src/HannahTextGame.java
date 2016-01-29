
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
			
			

		
		}

	}

}
