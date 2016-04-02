
public class Item {

	public String    name;
	public String descrip;
	public int value;
	public boolean isDiscoverd;
	public String use;
	
	public Item (String name,String descrip,String use,int value) {
		this.name    = name;
		this.descrip = descrip;
		this.use = use;
		this.value = value;
		this.isDiscoverd = false;
	}
	
	@Override
	public String toString() {
		   return this.name;
	}
}
