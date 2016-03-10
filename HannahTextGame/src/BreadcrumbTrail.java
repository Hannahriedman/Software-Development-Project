
public interface BreadcrumbTrail {

	public void dropCrumb(Object x); // push
	
	public void pickupCrumb(); // pop
	
	public Object currentCrumb(); //top
	
	public boolean hasMoreCrumbs(); //isEmpty
}
