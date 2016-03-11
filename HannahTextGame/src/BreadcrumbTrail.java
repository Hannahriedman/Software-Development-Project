
public interface BreadcrumbTrail {

	public void dropCrumb(int x); // push
	
	public void pickupCrumb(); // pop
	
	public int currentCrumb(); //top
	
	public boolean hasMoreCrumbs(); //isEmpty
}
