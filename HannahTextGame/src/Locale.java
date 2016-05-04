/**
 * Locale Class
 * This is for Locations in the game.
 * It contains a name, discription, item and 
 * person for each Location. It also contains 
 * a homemade toString method and name method.
 * @author hannahriedman
 *
 */
public class Locale {
	
	public String name;
	public String descrip;
	public Item   item;
	public Npc person;
	
	/**
	 * Location
	 * @param name: String of location name
	 * @param descrip: String of location description
	 * @param item: Item Object of what item is at location
	 */
	
	public Locale(String name, String descrip, Item item,Npc person) {
		this.name    = name;
		this.descrip = descrip;
		this.item    = item;
		this.person  = person; 
	}
	/**
	 * This is a toString override method.
	 * It will check to see if an item at a location is null,
	 * or if the item is not discovered yet and if one of those is ture 
	 * it returns a stirng with the name and descrip. 
	 * It will also return another string if there is an NPC in the room.
	 * Otherwise it will return a string with a name, descrip and item.name
	 */
	@Override
	public String toString() {
		   if (this.item == null || this.item.isDiscoverd == false ) {
			   if (this.person == null) {
				   return "You are now in the " + this.name + "\n" +  this.descrip;
			   } else {
				   return "You are now in the " + this.name + "\n" +  this.descrip +
						   this.person + " is in the room";   
			   }
			} else {
				if (this.person == null) {
					return "You are now in the " + this.name + "\n" +  this.descrip +
							   "\nThere is a " + this.item.name + " here.";
				} else {
					return "You are now in the " + this.name + "\n" +  this.descrip +
							this.person + " is in the room" + "\nThere is a " 
							+ this.item.name + " here.";
				}
			}
	}
	
	public String name () {
		return this.name;
	}
}
