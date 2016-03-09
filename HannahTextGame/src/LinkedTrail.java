

public class LinkedTrail implements BreadcrumbTrail {
	
	private Breadcrumb top;
	
	public LinkedTrail() {
		this.top = null;
	}
	
	public void pickupCrumb(Object x) {
		Breadcrumb newCrumb = new Breadcrumb(x, this.top);
		this.top = newCrumb;
	}
	
	public void dropCrumb() {
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
