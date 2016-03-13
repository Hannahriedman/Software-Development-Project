
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
	
	
	// Locale variables
	public String name; // location name
	public String descrip; // location description
	public String item;
	
	// Player variables
	static String   gender;
	static int      location  = 0;  
	static String   playerName;
	static String[] inventory = new String[4];

	// Cardinal directions
	static int north = 0;
	static int east  = 1;
	static int south = 2;
	static int west  = 3;
	
	static Scanner keyboard = new Scanner(System.in);
	
	static Item map1 = new Item("Map","This is a map of the mansion.Type M to use it.");
	static Item candlestick = new Item("Candlestick","This is a candlestick.");
	static Item rope = new Item("Rope","This is a thick braided rope.");
	static Item knife = new Item("Knife","This knife is bloody.");
	
	static Locale outside =        new Locale(
			"Outside",
			"You arrive at the creepy mansion in the dark of night.\n"
			+ "There is a large door in front of you.",
			null);
	static Locale foyer =          new Locale(
			"Foyer",
			"There is a study to the East and sitting room\n"
			+ "to the West. To the North is a hall.",
			map1);
	static Locale study =          new Locale(
			"Study",
			"To the North is a door.",
			null);
	static Locale sittingRoom =    new Locale(
			"Sitting Room",
			"The curtains look ripped.",
			candlestick);
	static Locale library =        new Locale(
			"Library",
			"The walls are lined with books.",
			null);
	static Locale secretStairway = new Locale(
			"Secret Stairway",
			"I wonder where it leads. Go North to go on stairs\n"
			+ "or East to go to the Library.",
			null);
	static Locale kitchen =        new Locale(
			"Kitchen",
			"The Kitchen looks messy like there might have been a fight."
			+ "There is a door to the south.",
			knife);
	static Locale hall =           new Locale(
			"Hall",
			"There is a door to the west.",
			null);
	static Locale diningRoom =     new Locale(
			"Dining Room",
			"There is a door to the north.",
			null);
	
	
	static Locale [] locations={outside,foyer,study,sittingRoom,library,secretStairway,kitchen,hall,diningRoom};
								// 0      1      2       3          4          5         6      7      8
	
	static int [][] map = {
	        // NORTH, EAST, SOUTH, WEST 
	           {1, -1, -1, -1 }, // from outside: Foyer ---
	           { 7, 2, -1,3 }, // from Foyer: hall study-sitting room 
	           { 4, -1, -1, 1 }, // from Study: library--Foyer
	           { -1, 1, -1, -1 }, // from SitingRoom: -Foyer--
	           { -1, -1, 2, 5 }, // from Library: --Study secret stairway
	           { 6, 4, -1, -1 }, // from SecretStairway: kitchen library --
	           { -1, 5, 8, -1 }, // from kitchen: -secret stairway dining room-
	           { -1, -1, 1, 8 }, // from hall: --Foyer diningRoom
	           { 6, 7, -1, -1 } // from dining room: kitchen hall--
	};
	
	static Player player1 = new Player(playerName,location,gender,inventory);
	
	static LinkedTrail trail = new LinkedTrail();

	public static void main(String[] args) {
		
		String direction;  // variable declarations 
		String userCommand;
		
		introMessage(); // method starts game and gets input from Player.
		
		while (true) {
			
			System.out.println("Enter a command: ");
			userCommand = keyboard.nextLine().toUpperCase();
			// makes input case in-sensititive.
		
			direction = processDirection(userCommand); // changes input into directions/commands
		
			if (direction.equals("quit")) {  // checks to see if you want to start over or quit
				break;  // quits game
			} else if (direction.equals("start over")) {
				continue; // starts loop over 
			}    

		
		}
		
		byeMessage();

	}
	
	// messages methods
	public static void introMessage() {
		
		System.out.println("Murder Mystery Game!");  // Title Screen
		System.out.println("********************\n");
		
		System.out.print("What is your character's name?"); // Character details
		player1.name = keyboard.nextLine();
		System.out.print("What is your character's gender?(m or f)");
		gender = keyboard.nextLine(); 
		playerGender(gender); // converts input into actual gender
		
		System.out.println(locations[0]); // start of game
		System.out.println("*************************************");
		System.out.println("Hello Detective " + player1.name +"! You can navigate the game by using\n" 
				+ "N,E,S,W commands.Type H to get help, Go North to the door to start the adventure!");
	}
	public static void byeMessage() {
		
		System.out.println("Thanks For Playing " + player1.name + " !\n"); 
		System.out.println("Creater: Hannah Riedman\n Copyright Hannah Games 2016");

		 
		keyboard.close();
	}
	
	// small method for player gender
	public static void playerGender(String gender) {
		
		if (gender.toUpperCase().equals("F")) {
			player1.gender = "Female";
		} else if (gender.toUpperCase().equals("M")){
			player1.gender = "Male";
		} else {
			player1.gender = "Gender Neutral";
		};
	}
	
	// user input method
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
			player1.take(locations);
			return "start over"; 
		} else if (userCommand.equals("B")) {
			backtrack();
			return "start over"; 
		} else if (userCommand.equals("D")) {
			///player1.drop(locations);
			return "start over"; 
		} else if (userCommand.equals("P")) {
			history(); 
			return "start over"; 
		}else if (userCommand.equals("H")) {
			System.out.println("Use the commands N,E,S,W to go in the cardnial directions\n"
					+ "Type 'Q' to quit the game, 'M' to see Map, and 'T' to take item.");
			return "start over";
		} else {
			System.out.println("Invalid command!\n");
			return "start over"; 
		}
		
		return direction;
	}
	
	// navigation methods
	public static int from (int dir) {
		int currentLocation = player1.location;
		
		return map[currentLocation][dir];
		
	}
	public static void move(int dir,String command) {
		int nextLocation = from(dir);// takes cardinal dir (0,1,2,3) and returns locale index
	
		if (nextLocation != -1) {
			trail.dropCrumb(player1.location); // drops crumb at last location
			System.out.println(locations[nextLocation]);
			player1.location=nextLocation;
		} else {
			System.out.println("You can not go " + command + ".");
			 
		}
	}
	
	// specific command methods
	public static void showMap () {
			
			if (player1.inventory.contains(map1)) {
				System.out.println("*********THE MAP*******");
				System.out.println("NOTE:there is one secret\nlocation not on map.---");
				System.out.println("-----------------------");
				System.out.println("-Kitchen---------------");
				System.out.println("---|-------------------");
				System.out.println("-DiningRm==Hall--Libray");
				System.out.println("------------|-------|--");
				System.out.println("SittingRm==Foyer==Study");
				System.out.println("-------------|---------");
				System.out.println("-----------Start-------");
			} else {
				System.out.println("You do not have the map!");
			}
		
		
	}
	
	public static void history () {
		Object lastLocation = locations[trail.currentCrumb()];
		System.out.println("Previous Moves: " + ((Locale) lastLocation).name());
		/**for (int i = 0; trail.hasMoreCrumbs();i--) {
			trail.indexof(i); 
			System.out.println(trail.currentCrumb());
		}**/
	}
	
	
	public static void backtrack () {
		System.out.println("Line 1!"); // using to test where code fails
		trail.pickupCrumb();
		if (trail.currentCrumb() != -1) {
			System.out.println("Line 2!");
			System.out.println(locations[trail.currentCrumb()]);
			player1.location = trail.currentCrumb();
		}
		
		
		
		
	}
	
		
		
		
		
}

	