
public class Locale {
	
	public String name;
	public String descrip;
	public Item   item;
	
	/**
	 * Location Class
	 * @param name: String of location name
	 * @param descrip: String of location description
	 * @param item: Item Object of what item is at location
	 */
	
	public Locale(String name, String descrip, Item item) {
		this.name    = name;
		this.descrip = descrip;
		this.item    = item;
	}
	/**
	 * This is a toString override method
	 * It will check to see if an item at a location is null
	 * or if the item is not discovered yet and if one of those is ture 
	 * it returns a stirng with the name and descrip
	 * Otherwise it will return a string with a name, descrip and item.name
	 */
	@Override
	public String toString() {
		   if (this.item == null || this.item.isDiscoverd == false) {
			   return "You are now in the " + this.name + "\n" +  this.descrip;
			} else {
			   return "You are now in the " + this.name + "\n" +  this.descrip +
					   "\nThere is a " + this.item.name + " here.";
			}
	}
	
	public String name () {
		return this.name;
	}
}
