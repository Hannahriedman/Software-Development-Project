import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	
	public String          name;
	public int             location =  0;
	public String          gender;
	public int             score =     0;
	public ArrayList<Item> inventory;
	static Scanner         keyboard1 = new Scanner(System.in);
	
	public Player(String name, int loc,String gender,String [] inventory) {
		this.name      = name;
		this.location  = loc;
		this.score     = 0;
		this.gender    = gender;
		this.inventory = new ArrayList<Item>();
		
		
	}
	
	public void take(Locale [] loc) {
		Locale currentloc = loc[this.location];
		Item itemHere     = currentloc.item;
		
		if (itemHere == null) {
			System.out.println("There is no item to take");
		} else {
			this.inventory.add(itemHere);
			currentloc.item = null;
			this.score += 5;
			System.out.println("You now have a " + itemHere.name + " .\n" 
			+ itemHere.descrip);
		}
	}
	
	
	public void drop(Locale [] loc) {
		Locale currentloc = loc[this.location];
		Item itemHere     = currentloc.item;
		String itemToDrop;
		Item checkItem;
		
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
