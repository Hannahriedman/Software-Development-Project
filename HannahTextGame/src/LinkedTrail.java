

public class LinkedTrail implements BreadcrumbTrail {
	
	private Breadcrumb top;
	
	public LinkedTrail() {
		this.top = null;
	}
	/**
	 * Push method
	 * @param takes in current location
	 */
	public void dropCrumb(int x) {
		Breadcrumb newCrumb = new Breadcrumb(x, this.top);
		this.top = newCrumb;
			
	}
	/**
	 * Pop method
	 */
	
	public void pickupCrumb() {
		if (this.top != null) {
			this.top = this.top.link;
			System.out.println("backtrack worked");
		} else {
			System.out.println("You cannot backtrack any further");
		}
		
	}
	/**
	 * Top method
	 */
	public int currentCrumb() {
		if (this.top != null) {
			return top.data;
		}
			return -1;
	}
	/**
	 * IsNotEmpty method
	 */
	public boolean hasMoreCrumbs() {
		return (top == null);
	}

}

class Breadcrumb {
	int data;
	Breadcrumb link;
	Breadcrumb(int x,Breadcrumb n) {
		this.data = x;
		this.link = n;
	}
}
