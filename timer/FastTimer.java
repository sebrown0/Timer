/**
 * 
 */
package timer;

import heartbeat.FastBeat;
import time.TimeFormatter;

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
	public FastTimer(TimeFormatter time, FastBeat fastBeat) {		
		super(time, fastBeat.getBeat(FastBeat.timeUnit));
	}
	
	/*
	 *  New fast timer with a specified duration.
	 */
	public FastTimer(TimeFormatter time, FastBeat fastBeat, long durationOfTimer) {		
		super(time, fastBeat.getBeat(FastBeat.timeUnit), durationOfTimer);
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
		System.out.println("Fast Timer - > " + time.formattedTime());		// TODO - R
		System.out.println("ms ->" + time.milliSeconds());					// TODO - R
	}

}
