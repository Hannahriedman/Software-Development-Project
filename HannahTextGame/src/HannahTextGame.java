
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
	
	static Item map1 =        new Item("map","This is a map of the mansion.Type M to use it.","Type M to see map.",10);
	static LimitedUseItem candlestick = new LimitedUseItem("candlestick","This is a candlestick.","The room is brighter now.",15,5);
	static Item rope =        new Item("rope","This is a thick braided rope.","The rope does nothing, you put it back.",5);
	static Item knife =       new Item("knife","This knife is bloody.","You aren't good with knifes, you cut yourself.",10);
	
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
	
	static Player player1 =    new Player(playerName,location,gender,inventory);
	
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
		trail.dropCrumb(player1.location); // puts first breadcrumb down at start location
		System.out.println("*************************************");
		System.out.println("Hello Detective " + player1.name +"! You can navigate the game by using\n" 
				+ "N,E,S,W commands.Type H to get a list of all commands, Go North to the door to start the adventure!");
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
		} else if (userCommand.startsWith("T")) {
			String item = stringConverter(userCommand.split("T "));
			player1.take(locations,item);
			return "start over"; 
		} else if (userCommand.equals("B")) {
			backtrack();
			return "start over"; 
		} else if (userCommand.startsWith("D")) {
			String item = stringConverter(userCommand.split("D "));
			player1.drop(locations,item);
			return "start over"; 
		} else if (userCommand.equals("P")) {
			playerStats(); 
			return "start over"; 
		} else if (userCommand.startsWith("U")) {
			String item = stringConverter(userCommand.split("U "));
			use(item); 
			return "start over"; 
		} else if (userCommand.equals("X")) {
			examine(); 
			return "start over"; 
		} else if (userCommand.equals("H")) {
			help();
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
			System.out.println(locations[nextLocation]);
			player1.location=nextLocation;
			trail.dropCrumb(player1.location); // drops crumb at current location
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
	public static void help () {
		System.out.println("COMMANDS");
		System.out.println("--------");
		System.out.println("'N','E','S','W' to go in the cardnial directions");
		System.out.println("'Q' to quit the game\n'M' to see Map\n'T' to take item*\n"
				+ "'D' to drop item*\n'P' to see player stats\n'X' to examine location for item\n"
				+ "'U' to use item*");
		System.out.println("*need a specified item after command.\n");
	}
	public static void playerStats () {
		
		System.out.println("Current Location: " + locations[player1.location].name);
		System.out.println("Current Points: " + player1.score);
		System.out.println("Inventory: " + player1.inventory);
	}
	public static void backtrack () {
		
		if (trail.hasMoreCrumbs()) { // checks to see if there is any crumbs left
			trail.pickupCrumb();
			if (trail.hasMoreCrumbs()) {
				System.out.println(locations[trail.currentCrumb()]);
				player1.location = trail.currentCrumb();
			} else {
				System.out.println("You cannnot go back any further!");
				
			}
		} else {
			System.out.println("You cannot go back any further!");
		}
	
}
	
	/** 
	 * Homemade "to string" method to properly convert 
	 * user input into string without hashcode. 
	 * @param userinput
	 * @return userinput into proper string
	 */
	public static String stringConverter (String[] userinput) {
		StringBuilder sb = new StringBuilder();
		
        for(String str : userinput) sb.append(str);
        return sb.toString().toLowerCase().trim();
		
	}
	
	public static void use(String item) {	
		String itemToUse = item;
		
		for (int i=0;i<player1.inventory.size();i++){
			Item checkItem =player1.inventory.get(i);
			if (checkItem.name.equals(itemToUse)) {
				if (checkItem.name.equals("candlestick")) {
					if (candlestick.uses()) {
						System.out.println("You now have the " + itemToUse + " Equiped.");
						System.out.println(checkItem.use);
					} else {
						System.out.println("You cannot use the " + itemToUse);
					}
				
				} else {
					System.out.println("You now have the " + itemToUse + " Equiped.");
					System.out.println(checkItem.use);
				}
			} 
			
		}
		
		
	}
	public static void examine() {
		Item itemAtLocation = locations[player1.location].item;
		if (itemAtLocation==null) {
			System.out.println("There is no item here.");
		} else {
			if (itemAtLocation.isDiscoverd == false) {
				itemAtLocation.isDiscoverd = true;
				System.out.println("After close examination you have found a " 
				+ itemAtLocation.name );
			} else {
				System.out.println("You have already discoverd the item here");
			}
		}
		
	}	
		
		
}

	