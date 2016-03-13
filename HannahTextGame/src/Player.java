import java.util.ArrayList;

public class Player {
	
	public String    name;
	public int       location = 0;
	public String    gender;
	public int       score = 0;
	public ArrayList<Item> inventory;
	
	public Player(String name, int loc,String gender,String [] inventory) {
		this.name      = name;
		this.location  = loc;
		this.score     = 0;
		this.gender    = gender;
		this.inventory = new ArrayList<Item>();
		
		
	}
	
	public void take(Locale [] loc) {
		Locale currentloc = loc[this.location];
		Item itemHere = currentloc.item;
		if (itemHere == null) {
			System.out.println("There is no item to take");
		} else {
			this.inventory.add(itemHere);
			currentloc.item = null;
		}
	}
	
	
	
	
	
}
