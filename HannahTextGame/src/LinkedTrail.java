

public class LinkedTrail implements BreadcrumbTrail {
	
	private Breadcrumb top;
	
	public LinkedTrail() {
		this.top = null;
	}
	/**
	 * Push method
	 * @param takes in current location
	 */
	public void dropCrumb(int loc) {
		Breadcrumb newCrumb = new Breadcrumb(loc, this.top);
		this.top = newCrumb;
			
	}
	/**
	 * Pop method
	 */
	
	public void pickupCrumb() {
			this.top = this.top.next;
			System.out.println("picked up crumb worked");
		
	}
	/**
	 * Top method
	 */
	public int currentCrumb() {
		if (hasMoreCrumbs()) {
			return top.data;
		} else {
			return -1;
		}
			
	}
	/**
	 * IsNotEmpty method
	 */
	public boolean hasMoreCrumbs() {
		return (this.top != null);
	}

}

class Breadcrumb {
	int data;
	Breadcrumb next;
	Breadcrumb(int loc,Breadcrumb n) {
		this.data = loc;
		this.next = n;
	}
}
