
public class Locale {
	
	public String name;
	public String descrip;
	public String item;
	public int index;
	
	public Locale(String name, String descrip, String item,int index) {
		this.name   = name;
		this.descrip = descrip;
		this.item  = item;
		this.index = index;
	}
	
	public String readLocation() {
		return this.descrip;
	}
	
	@Override
	public String toString() {
		return  this.descrip;
	}
}
