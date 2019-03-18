/**
 * 
 */
package timer;

import heartbeat.Beatable;
import heartbeat.BeatingHeart;
import heartbeat.SlowBeat;
import time.MutableTime;

/**
 * @author Steve Brown
 *
 *  A timer that runs with a HeartBeat.
 *  The timer ticks forward with an interval, measured in a unit specified by the HeartBeat. 
 *  
 *  The heart beat in turn is specified by the implementation of the timer.
 */

public abstract class Timer implements  Timers, Beatable {
	
	protected MutableTime time = null;				// We need a changeable time for a timer.
	protected BeatingHeart heartBeat = null;		// A heart beat to represent a 'tick'.
	private long beatCount =  0;					// How many beats has this timer had.
	private long durationOfTimer = 0;				// How long should this timer run for.
	private boolean timerRunning = false;			// Is the timer running.

	/*
	 *  New Timer with a starting time and heart beat to make it tick.
	 */
	public Timer(MutableTime time, BeatingHeart heartBeat) {
		this.time = time;
		this.heartBeat = heartBeat;
	}
	
	/*
	 *  New Timer with a starting time, duration and heart beat to make it tick.
	 */
	public Timer(MutableTime time, BeatingHeart heartBeat, TimerDurationSeconds durationOfTimer) {
		this.time = time;
		this.heartBeat = heartBeat;
		this.durationOfTimer = durationOfTimer.getDuration();
	}

	/*
	 *  Return the time for this timer.
	 */
	public MutableTime time() {
		return time;
	}
	
	/*
	 *  Return the heart beat for this timer.
	 */
	public BeatingHeart heartBeat() {
		return heartBeat;
	}
	
	/*
	 *  Check to see if the timer is running.
	 */
	public boolean timerRunning() {
		return timerRunning;
	}

	/*
	 * (non-Javadoc)
	 * @see timer.Timers#startTimer()
	 */
	@Override
	public void startTimer() {	
		timerRunning = true;
		if(durationOfTimer <= 0 ) {
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
		timerRunning = false;
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
		beatCount++;
		if(beatCount >= durationOfTimer) {
			// Timer has expired so stop it.
			stopTimer();
		}
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
