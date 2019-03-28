/**
 * 
 */
package timer;

import heartbeat.BeatingHeart;
import observer.Observer;
import time.MutableTime;

/**
 * @author Steve Brown
 *
 *  Abstract timer.
 */
public interface Timers {
	
	/*
	 *  Get the current time in the unit specified by the implementation.
	 *  For example if it's a slow timer the current time will be returned in seconds.
	 */
	int currentTime(); 
	
	/*
	 * TODO
	 */
	BeatingHeart heartBeat();

	/*
	 *  Increment time by 1ms (fast timer) or 1s (slow timer) or any Timers Interface.
	 */
	void incrementTimer();
	
	/*
	 * TODO
	 */
	void setObserver(Observer o);
	
	/*
	 *  Start the timer that runs indefinitely.
	 */
	void startTimer();
	
	/*
	 *  Stop the timer.
	 */
	void stopTimer();
	
	/*
	 *  TODO
	 */
	MutableTime time();
	
	/*
	 * TODO
	 */
	boolean timerRunning();
}
