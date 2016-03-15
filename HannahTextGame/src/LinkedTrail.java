

public class LinkedTrail implements BreadcrumbTrail {
	
	private Breadcrumb top;
	
	public LinkedTrail() {
		this.top = null;
	}
	/**
	 * Push method
	 * @param takes in current location index
	 */
	public void dropCrumb(int loc) {
		Breadcrumb newCrumb = new Breadcrumb(loc, this.top);
		this.top = newCrumb;
			
	}
	/**
	 * Pop method
	 * this is used with backtrack method to 
	 * pick up last crumb
	 */
	
	public void pickupCrumb() {
			this.top = this.top.next;
	}
	/**
	 * Top method
	 * @return integer that represnts location 
	 * on top of breadcrumbtrail
	 */
	public int currentCrumb() {
		if (hasMoreCrumbs()) {
			return top.data;
		} else {
			dropCrumb(0);
			return 0;
		}
	}
	/**
	 * IsNotEmpty method
	 * @return boolean that tells us if the 
	 * breadcrumbtrail has more crumbs left
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
