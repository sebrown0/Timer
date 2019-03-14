/**
 * 
 */
package timer;

import heartbeat.SlowBeat;
import time.MutableTime;

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
	public SlowTimer(MutableTime time, SlowBeat slowBeat) {		
		super(time, slowBeat.getBeat(SlowBeat.timeUnit));
	}

	/*
	 *  New slow timer with a specified duration.
	 */
	public SlowTimer(MutableTime time, SlowBeat slowBeat, long durationOfTimer) {		
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

	/*
	 * (non-Javadoc)
	 * @see timer.Timers#incrementTimer()
	 */
	@Override
	public void incrementTimer() {
		time.incrementSeconds();
	}

}
