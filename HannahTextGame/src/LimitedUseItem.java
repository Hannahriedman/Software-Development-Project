
public class LimitedUseItem extends Item {

	public int Usesremaining;
	
	public LimitedUseItem(String name, String descrip, int value,int remain) {
		super(name, descrip, value);
		this.Usesremaining = remain;
	}
	
	public boolean use() {
		if (this.Usesremaining == 0) {
			return false;
		} else {
			return true;
		}
		
	}

}
