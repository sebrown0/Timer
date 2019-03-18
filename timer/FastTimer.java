/**
 * 
 */
package timer;

import heartbeat.FastBeat;
import time.MutableTime;

/**
 * @author Steve Brown
 *  
 *  A Fast Timer implementation of a Timer
 *  It must have a fast heart beat.
 */
public class FastTimer extends Timer implements Timers {

	/*
	 *  New fast timer without a specified duration.
	 */
	public FastTimer(MutableTime time, FastBeat fastBeat, String owner) {		
		super(time, fastBeat.getBeat(FastBeat.timeUnit, owner, "FastTimer"));
	}
	
	/*
	 *  New fast timer with a specified duration.
	 */
	public FastTimer(MutableTime time, FastBeat fastBeat, TimerDurationSeconds durationOfTimer, String owner) {		
		super(time, fastBeat.getBeat(FastBeat.timeUnit, owner, "FastTimer"), durationOfTimer);
	}

	/*
	 * (non-Javadoc)
	 * @see timer.FastTimer#currentTime()
	 */
	@Override
	public int currentTime() {
		return time.milliSeconds();
	}

	/*
	 * (non-Javadoc)
	 * @see timer.Timers#incrementTimer()
	 */
	@Override
	public void incrementTimer() {
		time.incrementMilliSeconds();
	}

}
