
public class SecureLocale extends Locale {
	
	public Item requiredItem;
	
	public SecureLocale(String name, String descrip, Item item, Item required) {
		super(name, descrip, item);
		this.requiredItem = required;
		
	}
	
	public boolean cannotEnter(Player player) {
		if (player.inventory.contains(this.requiredItem)) {
			return false; // returns false if you can enter location
		} else {
			return true; // returns true if you cannot enter
		}
	
	}

}
