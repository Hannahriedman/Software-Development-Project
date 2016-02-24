
public class Player {
	
	public String    name;
	public int       location = 0;
	public String    gender;
	public int       score = 0;
	public String [] inventory= new String[4];
	
	public Player(String name, int loc,String gender,String [] inventory) {
		this.name      = name;
		this.location  = loc;
		this.score     = 0;
		this.inventory = inventory;
		this.gender    = gender;
		/**if (gender.equals("f")) {
			this.gender = "Female";
		} else if (gender.equals("m")){
			this.gender = "Male";
		} else {
			this.gender = "Gender Neutral";
		};**/ // for some reason this has an exception so need to TODO fix this
		
	}
	
}
