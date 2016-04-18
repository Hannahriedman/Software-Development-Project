
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
	static int      actionCount = 0;

	// Cardinal directions
	static int north = 0;
	static int east  = 1;
	static int south = 2;
	static int west  = 3;
	
	static Scanner keyboard = new Scanner(System.in);
	
	/**
	 * Initalizations of Items.
	 * 3 Items and 1 LimitedUseItem
	 */
	static Item map1 =                  new Item("map","This is a map of the mansion.Type M to use it.","Type M to see map.",10);
	static Item rope =                  new Item("rope","This is a thick braided rope.","The rope does nothing, you put it back.",5);
	static Item knife =                 new Item("knife","This knife is bloody.","You aren't good with knifes, you cut yourself.",10);
	static Item key = 					new Item("key","This is a key","I wonder where the key goes",10);
	static LimitedUseItem candlestick = new LimitedUseItem("candlestick","You can use this candle 5 times.","The room is brighter now.",15,5);
	
	/**
	 * Initalizations of Locations.
	 * 9 Locations
	 */
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
	static SecureLocale library =        new SecureLocale(
			"Library",
			"The walls are lined with books.",
			null,key);
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
			key);
	static Locale diningRoom =     new Locale(
			"Dining Room",
			"There is a door to the north.",
			rope);
	
	/**
	 * Location Array to keep all location Locale's
	 */
	static Locale [] locations={outside,foyer,study,sittingRoom,library,secretStairway,kitchen,hall,diningRoom};
								// 0      1      2       3          4          5         6      7      8
	/**
	 * Matrix map to navigate the game.
	 * Uses integers to represent the index of the location in the Location array above,
	 * and the cardnial directions users enter from a specific location.
	 * -1 represents where there is no way of going that way from that location.
	 */
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
	/**
	 * Initaixation of player 
	 */
	static Player player1 =    new Player(playerName,location,gender,inventory);
	
	/**
	 * Intialization of BreadcrumbTrail
	 */
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
			
			// checks to see if user loses or wins the game
			if (actionCount > 45) { // fails game when exceeds certain action count
				System.out.println("I am sorry, you have made too many moves, you lose.");
				break;
			} else if (player1.inventory.size() == 5) { // wins when collects all items
				System.out.println("Congrats! You have collected all the clues!");
				System.out.println("What item is the murder weapon? ");
				userCommand = keyboard.nextLine();
				System.out.println("You are right Detetive " + player1.name + "! It was the "
									+ userCommand);
				break;
			}
			
			if (direction.equals("quit")) {  // checks to see if you want to start over or quit
				break;  // quits game
			} else if (direction.equals("start over")) {
				continue; // starts loop over 
			}    

		
		}
		
		byeMessage();

	}
	
	/**
	 *  Messages methods.
	 *  Intro Message that starts everygame.
	 *  Goodbye method that ends game.
	 */
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
		System.out.println("Last Location: " + locations[player1.location].name);
		System.out.println("Total Points: " + player1.score);
		System.out.println("Inventory: " + player1.inventory);
	
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
	
	/**
	 * User Input Method.
	 * This method will intake user input and check to see
	 * if it matches one of the commands. If so it will properely 
	 * do whatever the command specifies and return "start over" so the 
	 * command prompt will appear agian once command is completeed
	 *  or it will return invalid command and prompt will reappear.
	 * @param userCommand: String of what the user typed in.
	 * @return "direction": String of start over or quit to repeat loop or get out of it
	 */
    public static String processDirection(String userCommand) {
		String direction = null;
		
		
		if (userCommand.equals("N")) { 
			direction = "North";
			actionCount += 1;
			move(north,direction);
		} else if (userCommand.equals("E")) { 
			direction = "East";
			actionCount += 1;
			move(east,direction);
		} else if (userCommand.equals("S")) { 
			direction = "South";
			actionCount += 1;
			move(south,direction);
		} else if (userCommand.equals("W")) { 
			direction = "West";
			actionCount += 1;
			move(west,direction);
		} else if (userCommand.equals("Q")) {
			return "quit"; 
		} else if (userCommand.equals("M")) {
			showMap();
			return "start over"; 
		} else if (userCommand.startsWith("T")) {
			String item = stringConverter(userCommand.split("T "));
			actionCount += 1;
			player1.take(locations,item);
			return "start over"; 
		} else if (userCommand.equals("B")) {
			actionCount += 1;
			backtrack();
			return "start over"; 
		} else if (userCommand.startsWith("D")) {
			String item = stringConverter(userCommand.split("D "));
			actionCount += 1;
			player1.drop(locations,item);
			return "start over"; 
		} else if (userCommand.equals("P")) {
			playerStats(); 
			return "start over"; 
		} else if (userCommand.startsWith("U")) {
			String item = stringConverter(userCommand.split("U "));
			actionCount += 1;
			use(item); 
			return "start over"; 
		} else if (userCommand.equals("X")) {
			actionCount += 1;
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
	
    /** 
	 * String Converter Method.
	 * This is a Homemade toString method to properly convert 
	 * user input array after input is split into a string. 
	 * @param userinput: Array of split user input
	 * @return userinput into proper string that is lower case and trimmed 
	 */
	public static String stringConverter (String[] userinput) {
		StringBuilder sb = new StringBuilder();
		
        for(String str : userinput) sb.append(str);
        return sb.toString().toLowerCase().trim();
		
	}
    
    // Navigation Methods: FROM & MOVE
	/**
	 * From Method: Takes in the cardnial direction as int and returns locale index
	 * @param dir the integer of the cardnail direction user wants to go 
	 * @return what int is at that spot in the map matrix (using current
	 * location and direction)
	 */
	public static int from (int dir) {
		int currentLocation = player1.location;
		
		return map[currentLocation][dir];
		
	}
	/**
	 * Move Method: uses from method to determin locale index,
	 * then checks if index is equal to -1, if so tell user they cannot go that way.
	 * If not, then print out the new location and set the players current location 
	 * to that location. Then drop a crumb at the current location.
	 * @param dir: integer that is the cardnial direction user wants to go
	 * @param command: String represention of cardnial direction.
	 */
	public static void move(int dir,String command) {
		int nextLocation = from(dir);// takes cardinal dir (0,1,2,3) and returns locale index
		
		// TO DO make this an instance of check instead
		if (nextLocation != -1) {
			Locale theLocation = locations[nextLocation]; // new desirered location as locale
			if (theLocation.name.equals("Library") && library.cannotEnter(player1)) {
				System.out.println("Sorry, you do not have the item to go to that location.");
			} else {
				System.out.println(theLocation);
				player1.location=nextLocation;
				trail.dropCrumb(player1.location); // drops crumb at current location
			}
		} else {
			System.out.println("You can not go " + command + ".");
			 
		}
	}
	
	// Specific Command Methods
	
	/**
	 * Show Map Method.
	 * This method prints out the map only if the player has the map in invnentory
	 */
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
	/**
	 * Help Method.
	 * This method prints out a list of Commands that the user can enter 
	 */
	public static void help () {
		System.out.println("COMMANDS");
		System.out.println("--------");
		System.out.println("'N','E','S','W' to go in the cardnial directions");
		System.out.println("'Q' to quit the game\n'M' to see Map\n'T' to take item*\n"
				          + "'D' to drop item*\n'P' to see player stats\n"+ 
				          "'X' to examine location for item\n'U' to use item*");
		System.out.println("*need a specified item after command.\n");
	}
	/**
	 * PLayer Satistics Method.
	 * This Method prints out all of the players current statistics,
	 * including current location, current points, and inventory.
	 */
	public static void playerStats () {
		
		System.out.println("Current Location: " + locations[player1.location].name);
		System.out.println("Current Points: " + player1.score);
		System.out.println("Inventory: " + player1.inventory);
	}
	/**
	 * Backtrack Method.
	 * This method checks to see if there are any crumbs in trail, 
	 * then it picks up the top crumb, then it checks again to see if there are 
	 * any more crumbs and if there are it prints out the location of that crumb
	 * and sets players location to the crumb.
	 */
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
	 * Use Method.
	 * Loop to check every spot in inventory list and see if 
	 * it matches up with the String of the user input. If so,
	 * Then check to see if it is the limitedUseItem, which if so 
	 * will see if there are uses left and subtracts one if there is
	 * then prints out proper message
	 * @param item: String of item the user wants to use.
	 */
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
	/**
	 * Examine Method.
	 * This method checks if there is an item there or not.
	 * if so, then check if the item is discovered and if not it 
	 * makes it discoverable and prints message. 
	 */
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

	