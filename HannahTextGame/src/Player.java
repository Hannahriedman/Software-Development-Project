import java.util.ArrayList;


public class Player {
	
	public String          name;
	public int             location  = 0;
	public String          gender;
	public int             score     = 0;
	public ArrayList<Item> inventory;
	/**
	 * PLayer Class
	 * @param name: String of player name
	 * @param loc: integer of current location
	 * @param gender: String of player gender
	 * @param inventory: String array List of player's items or inventory
	 * score: interger of players score. default is at 0.
	 */
	public Player(String name, int loc,String gender,String [] inventory) {
		this.name      = name;
		this.location  = loc;
		this.score     = 0;
		this.gender    = gender;
		this.inventory = new ArrayList<Item>();
		
		
	}
	
	/**
	 * Take method 
	 * First checks to see if item is at location,
	 * If yes, then check if item is discovered and if item equals
	 * what item they said in command, then: add item to inventory, remove
	 * item from location and add to score the value of Object.
	 * @param loc is the location array of loc Objects.
	 * @param item is the item the user wishes to drop.
	 */
	public void take(Locale [] loc,String item) {
		Locale currentloc = loc[this.location];
		Item   itemHere   = currentloc.item;
		String itemToTake = item;
		
		if (itemHere == null) { // checks if there is item at location 
			System.out.println("There is no item here to take");
		} else { 
			if (itemHere.isDiscoverd && itemHere.name.equals(itemToTake)) {
				this.inventory.add(itemHere); 
				currentloc.item = null; 
				this.score += itemHere.value;
				System.out.println("You now have a " + itemHere.name + ".\n" 
				+ itemHere.descrip);
			} else {
				System.out.println("There is no visble item to take.");
			}
		}
	}

	/**
	 * Drop method
	 * Checks if there is an object already at location, if not 
	 * then checks if user input equals an item in inventory.
	 * Then it drops item and subtracts its worth.
	 * @param loc is the location array of loc Objects.
	 * @param item is the item the user wishes to drop.
	 */
	public void drop(Locale [] loc,String item) {
		Locale currentloc = loc[this.location];
		Item   itemHere   = currentloc.item;
		String itemToDrop = item;
		Item   checkItem;

		if (itemHere == null) {
			System.out.println(itemToDrop);
			for (int i=0;i<this.inventory.size();i++){
				checkItem =this.inventory.get(i);
				if (checkItem.name.equals(itemToDrop)) {
					System.out.println("You have dropped the " + itemToDrop);
					currentloc.item = checkItem;
					this.inventory.remove(i);
					this.score -= checkItem.value;
				} 
				
			}
		} else {
			System.out.println("There is already an item here you cannot drop something here.");
		}
			
		
	}
	
	
}
