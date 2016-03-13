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
	
	public void take() {
		Item itemHere = locations[this.location].item;
	}
	
	
	
	
	
}
