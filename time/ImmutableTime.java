/**
 * 
 */
package time;

/**
 * @author Steve Brown
 *
 *  An ImmutableTime cannot be changed. It can only be read.
 */
public interface ImmutableTime {
	
	/*
	 *  Get the time that the object was created with in seconds.
	 */
	int givenTimeSeconds();
	
	/*
	 *  Get the time in seconds for the given H, M, S.
	 */
	int getTimeInSeconds(int hours, int minutes, int seconds);
	
	
	/*
	 *  Get the time in the format hh:mm:ss.
	 */
	String formattedTime();

	/*
	 *  Get the current millisecond.
	 */
	int milliSeconds();
	
	/*
	 *  Get the current second.
	 */
	int seconds();
	
	/*
	 *  Get the current minute.
	 */
	int minutes();
	
	/*
	 *  Get the current hour.
	 */
	int hours();

}
