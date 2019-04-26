/**
 * 
 */
package time;

/**
 * @author Steve Brown
 *
 *  A MutableTime can be changed (incremented).
 */
public interface MutableTime extends ImmutableTime{
	
	/*
	 *  Increment time by 1s.
	 */
	void incrementMilliSeconds();
	
	/*
	 *  Increment time by 1s.
	 */
	void incrementSeconds(); 
	
	/*
	 *  Get the current time in seconds
	 */
	int currentTime();
}
