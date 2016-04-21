
public class SecureLocale extends Locale {
	
	public Item requiredItem;
	
	/**
	 * Secure Location Class
	 * Extends Locale Class
	 * @param name: String of location name
	 * @param descrip: String of location description
	 * @param item: Item Object of what item is at location
	 * @param required: Item Object of what item is required in order to
	 * unlock this secure location
	 */
	
	public SecureLocale(String name, String descrip, Item item, Item required) {
		super(name, descrip, item);
		this.requiredItem = required;
		
	}
	
	/**
	 * Cannot Enter Method
	 * @param player: takes in the player object 
	 * @return bootlean if you cannot enter the location returns false or if you can it 
	 * returns true
	 */
	public boolean cannotEnter(Player player) {
		if (player.inventory.contains(this.requiredItem)) {
			return false; // returns false if you can enter location
		} else {
			return true; // returns true if you cannot enter
		}
	
	}

}
