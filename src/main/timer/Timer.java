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
public interface Timer extends CurrentTime, StopStart{
		
	/*
	 *  Get the heartbeat of this timer.
	 */
//	BeatingHeart heartBeat();

	/*
	 *  Increment time by 1ms (fast timer) or 1s (slow timer) or any Timers Interface.
	 */
	void incrementTimer();
	
	/*
	 * Set an observer of this timer.
	 */
	void setObserver(Observer o);
	
	/*
	 *  Return the time object within the timer.
	 */
	MutableTime time();
	
	/*
	 * Is the timer runnig.
	 */
	boolean timerRunning();
	
}
