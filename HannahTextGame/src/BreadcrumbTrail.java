/**
 * BreadCrumb Trail Interface
 * This is for the Stack- like LinkedTrail Class.
 * @author hannahriedman
 *
 */
public interface BreadcrumbTrail {

	public void    dropCrumb(int x); // push
	
	public void    pickupCrumb(); // pop
	
	public int     currentCrumb(); //top
	
	public boolean hasMoreCrumbs(); //isEmpty
}
