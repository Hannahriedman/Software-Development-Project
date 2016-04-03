
public class LimitedUseItem extends Item {

	public int usesremaining;
	

	public LimitedUseItem(String name, String descrip,String use,int value,int remain) {
		super(name, descrip, use, value);
		this.usesremaining = remain;
	}
	
	public boolean uses() {
		if (this.usesremaining == 0) {
			return false;
		} else {
			return true;
		}
	
	}

}
