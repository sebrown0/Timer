/**
 * 
 */
package timer;

/**
 * @author Steve Brown
 *
 *  Abstract timer.
 */
public interface Timers {
	
	/*
	 *  Increment time by 1ms (fast timer) or 1s (slow timer) or any Timers Interface.
	 */
	void incrementTimer(); 
	
	/*
	 *  Start the timer that runs indefinitely.
	 */
	void startTimer();

	/*
	 *  Start a timer that last for a specified duration.
	 */
	void startTimer(long durationOfTimer); 
	
	/*
	 *  Stop the timer.
	 */
	void stopTimer();
	
	/*
	 *  Get the current time in the unit specified by the implementation.
	 *  For example if it's a slow timer the current time will be returned in seconds.
	 */
	int currentTime();
	
}
