/**
 * Limited Use Item Class
 * This is for special items that can only be used a 
 * certain amount of times. This extends the Item class
 * as well as containing usesreamining. This also has a
 * uses method. 
 * @author hannahriedman
 *
 */
public class LimitedUseItem extends Item {

	public int usesremaining;
	
	/**
	 * Extends Item Class 
	 * @param name: String of name of the item
	 * @param descrip: String of Description of the iem
	 * @param use: String of what use does the item have
	 * @param value: integer of amount of points item is worth
	 * @param remain: Integer to tell us how many uses remain for the object
	 */
	public LimitedUseItem(String name, String descrip,String use,String prints,int value,int remain) {
		super(name, descrip, use, prints, value);
		this.usesremaining = remain;
	}
	/**
	 * Uses method.
	 * Checks to see if the item has uses remaining and then if it does it subtracts one
	 * @return Boolean either true if it was sucessful to use or false if no more uses remain.
	 */
	public boolean uses() {
		if (this.usesremaining == 0) {
			return false;
		} else {
			this.usesremaining -= 1;
			return true;
		}
	
	}

}
