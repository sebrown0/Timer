/**
 * 
 */
package timer;

import heartbeat.SlowBeat;
import time.TimeFormatter;

/**
 * @author Brown
 *
 *  A Slow Timer implementation of a Timer
 *  It must have a slow heart beat.
 */
public class SlowTimer extends Timer implements Timers {

	/*
	 *  New slow timer without a specified duration.
	 */
	public SlowTimer(TimeFormatter time, SlowBeat slowBeat) {		
		super(time, slowBeat.getBeat(SlowBeat.timeUnit));
	}

	/*
	 *  New slow timer with a specified duration.
	 */
	public SlowTimer(TimeFormatter time, SlowBeat slowBeat, long durationOfTimer) {		
		super(time, slowBeat.getBeat(SlowBeat.timeUnit), durationOfTimer);
	}
	
	/*
	 * (non-Javadoc)
	 * @see timer.SlowTimer#currentTime()
	 */
	@Override
	public int currentTime() {
		return time.seconds();
	}

	@Override
	public void incrementTimer() {
		time.incrementSeconds();
		System.out.println("Slow Timer - > " + time.formattedTime());		// TODO - R
	}
}
