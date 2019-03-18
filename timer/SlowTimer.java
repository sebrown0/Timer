/**
 * 
 */
package timer;



import timer.TimerDurationSeconds;
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
	public SlowTimer(MutableTime time, SlowBeat slowBeat, String owner) {		
		super(time, slowBeat.getBeat(SlowBeat.timeUnit, owner, "SlowTimer"));
	}

	/*
	 *  New slow timer with a specified duration.
	 */
	public SlowTimer(MutableTime time, SlowBeat slowBeat, TimerDurationSeconds durationOfTimer, String owner) {		
		super(time, slowBeat.getBeat(SlowBeat.timeUnit, owner, "SlowTimer"), durationOfTimer);
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
