
public class Item {

	public String  name;
	public String  descrip;
	public int     value;
	public boolean isDiscoverd;
	public String  use;
/**	
 * Item class 
 * @param name: String of name of the item
 * @param descrip: String of Description of the iem
 * @param use: String of what use does the item have
 * @param value: integer of amount of points item is worth. 
 * 
 * isDiscovered: boolean to determine if player has discovered item yet
 * default is false 
 * 
 */
	public Item (String name,String descrip,String use,int value) {
		this.name        = name;
		this.descrip     = descrip;
		this.use         = use;
		this.value       = value;
		this.isDiscoverd = false;
	}
	
	@Override
	public String toString() {
		   return this.name;
	}
}
