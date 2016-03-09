
public interface BreadcrumbTrail {

	public void pickupCrumb(Object x);
	
	public void dropCrumb();
	
	public Object currentCrumb();
	
	public boolean hasMoreCrumbs();
}
