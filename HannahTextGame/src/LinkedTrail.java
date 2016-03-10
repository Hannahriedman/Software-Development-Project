

public class LinkedTrail implements BreadcrumbTrail {
	
	private Breadcrumb top;
	
	public LinkedTrail() {
		this.top = null;
	}
	/**Push method
	 * @param takes in current location
	 */
	public void dropCrumb(Object x) {
		Breadcrumb newCrumb = new Breadcrumb(x, this.top);
		this.top = newCrumb;
	}
	
	public void pickupCrumb() {
		this.top = this.top.link;
	}
	
	public Object currentCrumb() {
		return top.data;
	}
	
	public boolean hasMoreCrumbs() {
		return (top == null);
	}

}

class Breadcrumb {
	Object data;
	Breadcrumb link;
	Breadcrumb(Object x,Breadcrumb n) {
		this.data = x;
		this.link = n;
	}
}
