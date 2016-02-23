
public class Player {
	
	public String name;
	public int location = 0;
	public int score = 0;
	public String [] inventory= new String[4];
	
	public Player(String name, int loc,String [] inventory) {
		this.name   = name;
		this.location = loc;
		this.score = 0;
		this.inventory = inventory;
	}
	
}
