import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	
	public String          name;
	public int             location  = 0;
	public String          gender;
	public int             score     = 0;
	public ArrayList<Item> inventory;
	static Scanner         keyboard1 = new Scanner(System.in);
	
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
	 * If yes, then add item to inventory, remove
	 * item from location and add 5 points to score.
	 * @param loc is the location array of loc Objects.
	 */
	public void take(Locale [] loc) {
		Locale currentloc = loc[this.location];
		Item   itemHere   = currentloc.item;
		
		if (itemHere == null) { // checks if there is item at location 
			System.out.println("There is no item to take");
		} else { 
			this.inventory.add(itemHere); 
			currentloc.item = null; 
			this.score += 5;
			System.out.println("You now have a " + itemHere.name + " .\n" 
			+ itemHere.descrip);
		}
	}
	
	/**
	 * Drop method
	 * Prompts user what they want to drop, Checks if
	 * there is an object already at location, if not 
	 * then checks if user input equals the item there.
	 * Then it drops item and subtracts 5 points.
	 * @param loc is the location array of loc Objects.
	 */
	public void drop(Locale [] loc) {
		Locale currentloc = loc[this.location];
		Item   itemHere   = currentloc.item;
		String itemToDrop;
		Item   checkItem;
		
		System.out.println("What item do you want to drop?");
		itemToDrop = keyboard1.nextLine().toLowerCase();
		
		if (itemHere == null) {
			for (int i=0;i<this.inventory.size();i++){
				checkItem =this.inventory.get(i);
				if (checkItem.name.equals(itemToDrop)) {
					System.out.println("You have dropped the " + itemToDrop);
					currentloc.item = checkItem;
					this.inventory.remove(i);
					this.score -= 5;
				} 
				
			}
		} else {
			System.out.println("There is already an item here you cannot drop something here.");
		}
			
		
	}
	
	
}
