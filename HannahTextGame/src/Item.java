/**
 * Item Class
 * This is for all the items in the game.
 * It contains a name, discription, value,
 * use, prints and isDiscovered for every item.
 * It also contains a homemade toString method.
 * @author hannahriedman
 *
 */
public class Item {

	public String  name;
	public String  descrip;
	public int     value;
	public boolean isDiscoverd;
	public String  use;
	public String  prints;
/**	
 * Item  
 * @param name: String of name of the item
 * @param descrip: String of Description of the iem
 * @param use: String of what use does the item have
 * @param prints: String of what fingerprints item has.
 * @param value: integer of amount of points item is worth. 
 * 
 * isDiscovered: boolean to determine if player has discovered item yet
 * default is false 
 * 
 */
	public Item (String name,String descrip,String use,String prints,int value) {
		this.name        = name;
		this.descrip     = descrip;
		this.use         = use;
		this.prints      = prints;
		this.value       = value;
		this.isDiscoverd = false;
	}
	
	@Override
	public String toString() {
		   return this.name;
	}
}
