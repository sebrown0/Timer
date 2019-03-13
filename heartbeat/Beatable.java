/**
 * 
 */
package heartbeat;

/**
 * @author Steve Brown
 *
 *  An abstract layer between a runnable object and an object with a heart beat.
 *  Any object that has a beating heart needs to be beatable.
 */
public interface Beatable extends Runnable{
	
	/*
	 *  Should be over ridden by any object that implements BeatingHeart.
	 *  And called from the run of the implementing object.
	 *  
	 *  Not strictly needed as the logic could be implemented in run().
	 *  However, this represents the Heart Beat. 
	 */
	void beat();
}
