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

	public FastTimer(TimeFormatter time, FastBeat fastBeat) {		
		super(time, fastBeat.getBeat(FastBeat.timeUnit));
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
