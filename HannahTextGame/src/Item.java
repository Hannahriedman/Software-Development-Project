
public class Item {

	public String    name;
	public String descrip;
	public int value;
	public boolean isDiscoverd;
	
	public Item (String name,String descrip,int value) {
		this.name    = name;
		this.descrip = descrip;
		this.value = value;
		this.isDiscoverd = false;
	}
	
	@Override
	public String toString() {
		   return this.name;
	}
}
