/**
 * Npc Class 
 * This Class is For Non-Player Characters and contains
 * Name, location, 2 diogloge options depending on player trait 
 * and one special string that will show up if player trait is 
 * observent. It also contains a homemade toString method to print 
 * out the name of the NPC.
 * @author hannahriedman
 *
 */
public class Npc {
	
	public String          name;
	public int             location  = 0;
	public String 		   dialogue1;
	public String 		   dialogue2;
	public String 		   observent;
	
	public Npc(String name, int loc,String dialogue1,String dialogue2,String observent) {
		this.name      = name;
		this.location  = loc;
		this.dialogue1 = dialogue1;
		this.dialogue2 = dialogue2;
		this.observent = observent;
		
	}
	
	@Override
	public String toString() { 
		return this.name;
	}
	
}
