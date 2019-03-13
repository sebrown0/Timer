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
	private long durationOfTimer = 0;

	/*
	 *  New Timer with a starting time and heart beat to make it tick.
	 */
	public Timer(TimeFormatter time, BeatingHeart heartBeat) {
		this.time = time;
		this.heartBeat = heartBeat;
	}
	
	/*
	 *  New Timer with a starting time and heart beat to make it tick.
	 */
	public Timer(TimeFormatter time, BeatingHeart heartBeat, long durationOfTimer) {
		this.time = time;
		this.heartBeat = heartBeat;
		this.durationOfTimer = durationOfTimer;
	}
	
	/*
	 *  Return the time for this timer.
	 */
	public TimeFormatter time() {
		return time;
	}
	
	/*
	 *  Return the heart beat for this timer.
	 */
	public BeatingHeart heartBeat() {
		return heartBeat;
	}

	/*
	 * (non-Javadoc)
	 * @see timer.Timers#startTimer()
	 */
	@Override
	public void startTimer() {	
		if(durationOfTimer > 0 ) {
			heartBeat.startBeating(this);
		} else {
			heartBeat.startBeating(this, durationOfTimer);
		}
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
