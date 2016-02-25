
public class Locale {
	
	public String name;
	public String descrip;
	public String item;
	
	public Locale(String name, String descrip, String item) {
		this.name    = name;
		this.descrip = descrip;
		this.item    = item;
	}

	@Override
	public String toString() {
		return  "You are now in the " + this.name + "\n" +  this.descrip + 
				"\nThere is a " + this.item + " Here.";
	}
}
