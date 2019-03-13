/**
 * 
 */
package time;

/**
 * @author Steve Brown
 *
 */
public interface TimeFormatter {
	
	/*
	 *  Increment time by 1s.
	 */
	void incrementMilliSeconds();
	
	/*
	 *  Increment time by 1s.
	 */
	void incrementSeconds(); 
	
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
