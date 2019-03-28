/**
 * 
 */
package timer;



import heartbeat.SlowBeat;
import heartbeat.SlowHeartbeat;
import observer.Observer;
import time.MutableTime;

/**
 * @author Steve Brown
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
	 *  New slow timer with a specified duration and HeartBeat.
	 *  Using this configuration allows a target object to have a Timer and a HeartBeat running in synch.
	 */
	public SlowTimer(MutableTime time, SlowBeat slowBeat, TimerDurationSeconds durationOfTimer, String owner) {		
		super(time, slowBeat, durationOfTimer);
	}
	
	/*
	 *  New slow timer with a specified duration and HeartBeat.
	 *  Using this configuration allows a target object to have a Timer and a HeartBeat running in synch.
	 */
	public SlowTimer(MutableTime time, SlowBeat slowBeat, TimerDurationSeconds durationOfTimer, String owner, Observer timerObserver) {		
		super(time, slowBeat, durationOfTimer, timerObserver);
	}
	
	/*
	 *  New slow timer with a specified duration.
	 */
	public SlowTimer(MutableTime time, TimerDurationSeconds durationOfTimer, String owner) {		
		super(time, new SlowHeartbeat(owner).getBeat(SlowBeat.timeUnit, owner, "SlowTimer"), durationOfTimer);
	}
	
	/*
	 * (non-Javadoc)
	 * @see timer.SlowTimer#currentTime()
	 */
	@Override
	public int currentTime() {
		return super.time().currentTime();
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
