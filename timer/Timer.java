/**
 * 
 */
package timer;

import heartbeat.Beatable;
import heartbeat.BeatingHeart;
import time.TimeFormatter;

/**
 * @author Steve Brown
 *
 *  A timer that runs with a HeartBeat.
 *  The timer ticks forward with an interval, measured in a unit specified by the HeartBeat. 
 *  
 *  The heart beat in turn is specified by the implementation of the timer.
 */

public abstract class Timer implements  Timers, Beatable {
	
	protected TimeFormatter time = null;
	protected BeatingHeart heartBeat = null;

	/*
	 *  New Timer with a starting time and heart beat to make it tick.
	 */
	public Timer(TimeFormatter time, BeatingHeart heartBeat) {
		this.time = time;
		this.heartBeat = heartBeat;
	}
	
	/*
	 *  Return the time for this timer.
	 */
	public TimeFormatter time() {
		return time;
	}

	/*
	 * (non-Javadoc)
	 * @see timer.Timers#startTimer()
	 */
	@Override
	public void startTimer() {	
		heartBeat.startBeating(this);
	}
	
	/*
	 * (non-Javadoc)
	 * @see timer.Timers#startTimer()
	 */
	@Override
	public void startTimer(long durationOfTimer) {	
		heartBeat.startBeating(this, durationOfTimer);
	}
	
	/*
	 * (non-Javadoc)
	 * @see timer.Timers#stopTimer()
	 */
	@Override
	public void stopTimer() {	
		heartBeat.stopBeating();
	}
	
	/*
	 * (non-Javadoc)
	 * @see heartbeat.BeatingHeart#beat()
	 */
	@Override
	public void beat() {
		// Increment the number of heart beats.
		heartBeat.anotherBeat();  				
		// Increment this timer's measurement of time.
		incrementTimer();
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		beat();
	}
}
