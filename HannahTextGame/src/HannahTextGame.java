
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
	
	public String name; // location name
	public String descrip;
	public int index;
	static String gender;
	static int location = 0; // static variable declarations 
	static String playerName;
	static String[] inventory;
	//static int index;
	
	static int north = 0;
	static int east = 1;
	static int south = 2;
	static int west = 3;
	
	static Scanner keyboard = new Scanner(System.in);
	
	static Locale outside = new Locale(
			"Outside",
			"You arrive at the creepy mansion in the dark of night.\n"
			+ "There is a large door in front of you.",
			"no item",0);
	static Locale foyer = new Locale(
			"Foyer",
			"You are now in the Foyer. There is a study to the East and sitting room\n"
			+ "to the West.",
			"no item",1);
	static Locale study = new Locale(
			"Study",
			"You are now in the Study. To the North is a door.",
			"Dictonary",2);
	static Locale sittingRoom = new Locale(
			"Sitting Room",
			"You are now in the Sitting Room.",
			"CandleStick",3);
	static Locale library = new Locale(
			"Library",
			"You are now in the Library.",
			"Rope",4);
	static Locale secretStairway = new Locale(
			"Secret Stairway",
			"You have found a secret stairway after leaning on the bookcase.\n"
			+ "Go North to go on stairs",
			"no item",5);
	static Locale kitchen = new Locale(
			"Kitchen",
			"You take the stairs and they lead you to the Kitchen.\n"
			+"The Kitchen looks messy like there might have been a fight.",
			"Knife",6);
	static Locale hall = new Locale(
			"Hall",
			"You Proceed down the hall from the Foyer,There is a door to the west.",
			"no item",7);
	static Locale diningRoom = new Locale(
			"Dining Room",
			"You are now in the Dining Room.",
			"no item",8);
	
	static Object [] locations={outside,foyer,study,sittingRoom,library,secretStairway,kitchen,hall,diningRoom};
								// 0      1      2       3          4          5         6      7      8
	static Object [][] map = {
	           // NORTH, EAST, SOUTH, WEST 
	           {locations[1], null, null, null }, // from outside: Foyer ---
	           { null, locations[2], null, locations[3] }, // from Foyer: hall study-sitting room 
	           { locations[4], null, null, locations[1] }, // from Study: library--Foyer
	           { null, locations[1], null, null }, // from SitingRoom: -Foyer--
	           { null, null, locations[2], locations[5] }, // from Library: --Study secret stairway
	           { locations[6], locations[4], null, null }, // from SecretStairway: kitchen library --
	           { null, null, locations[5], null }, // from kitchen: --secret stairway-
	           { null, null, locations[1], locations[8] }, // from hall: --Foyer diningRoom
	           { null, locations[7], null, null } // from dining room: -hall--
	};
	
	static Player player1 = new Player(playerName, location,gender, inventory);
	

	public static void main(String[] args) {
		
		String direction;  // variable declarations 
		String userCommand;
		
		System.out.println("Murder Mystery Game!");  // Intro and character customization
		System.out.println("********************\n");
		System.out.print("What is your character's name?");
		player1.name = keyboard.nextLine();
		System.out.print("What is your character's gender?(m or f)");
		player1.gender = keyboard.nextLine(); // test to check gender
		System.out.println(player1.gender);
		System.out.println(locations[0]); // start of game
		System.out.println("*************************************");
		System.out.println("Hello Detective " + player1.name +"! You can navigate the game by using\n" 
				+ "N,E,S,W commands. Go North to the door to start the adventure!");
		
		while (true) {
			
			System.out.println("Enter a command: ");
			userCommand = keyboard.nextLine().toUpperCase();
			// makes input case sensititive.
			System.out.println("You entered: " + userCommand);
			direction = processDirection(userCommand); // changes input into directions/commands
		
			if (direction.equals("quit")) {  // checks to see if you want to start over or quit
				break;  // quits game
			} else if (direction.equals("start over")) {
				continue; // starts loop over 
			} 
			
			//navigation(direction); // takes direction input and changes location   

		
		}
		
		System.out.println("Thanks For Playing " + player1.name + " !\n"); 
		System.out.println("Creater: Hannah Riedman\n Copyright Hannah Games 2016");

		 
		keyboard.close();

	}
	
	public static String processDirection(String userCommand) {
		String direction = null;
		
		if (userCommand.equals("N")) { 
			direction = "North";
			move(north,direction);
		} else if (userCommand.equals("E")) { 
			direction = "East";
			move(east,direction);
		} else if (userCommand.equals("S")) { 
			direction = "South";
			move(south,direction);
		} else if (userCommand.equals("W")) { 
			direction = "West";
			move(west,direction);
		} else if (userCommand.equals("Q")) {
			return "quit"; 
		} else if (userCommand.equals("M")) {
			showMap();
			return "start over"; 
		} else if (userCommand.equals("T")) {
			//takeItem();
			return "start over"; 
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
		Object currentLoc = locations[location];
		
		System.out.println(currentLoc);
		return location;
		
	}
	
	public static Object from (int dir) {
		int location = player1.location;
		//Object locId = locations[location];
		return map[location][dir];
		
	}
	public static void move(int dir, String command) {
		Object nextLocation = from(dir);// takes cardinal dir (0,1,2,3) and returns locale instance
		
		int currentLocation = nextLocation.index;
		if (nextLocation.equals(null)) {
			System.out.println("You can not go " + command + " .");// add in stuff about you can not go here
		} else {
			System.out.println(nextLocation);
			player1.location = Location;
			/** add in stuff about changing currentlocation in player to next
			/
			 */
			 
		}
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
				location = processLocation(1);
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
	
	public static void showMap () {
		System.out.println();
	}
	
	public void takeItem (Object Location) {
		
		if(Locale.item.equals("no item")) {
			System.out.println("There is no item here!");
		}
	}
}
	