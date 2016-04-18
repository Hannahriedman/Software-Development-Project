
public class SecureLocale extends Locale {
	
	public Item requiredItem;
	
	public SecureLocale(String name, String descrip, Item item, Item required) {
		super(name, descrip, item);
		this.requiredItem = required;
		
	}
	
	public boolean canEnter(Player player) {
		if (player.inventory.contains(this.requiredItem)) {
			return true;
		} else {
			return false;
		}
	
	}

}
