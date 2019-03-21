/**
 * 
 */
package timer;

import heartbeat.FastBeat;
import heartbeat.FastHeartbeat;
import heartbeat.SlowBeat;
import heartbeat.SlowHeartbeat;
import observer.Observer;
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
	public FastTimer(MutableTime time, TimerDurationSeconds durationOfTimer, String owner) {		
		super(time, new FastHeartbeat(owner).getBeat(FastBeat.timeUnit, owner, "FastTimer"), durationOfTimer);
	}
	
	/*
	 *  New fast timer with a specified duration and HeartBeat.
	 *  Using this configuration allows a target object to have a Timer and a HeartBeat running in synch.
	 */
	public FastTimer(MutableTime time, FastBeat fastBeat, TimerDurationSeconds durationOfTimer, String owner) {		
		super(time, fastBeat, durationOfTimer);
	}

	/*
	 *  New fast timer with a specified duration and HeartBeat.
	 *  Using this configuration allows a target object to have a Timer and a HeartBeat running in synch.
	 */
	public FastTimer(MutableTime time, SlowBeat slowBeat, TimerDurationSeconds durationOfTimer, String owner, Observer timerObserver) {		
		super(time, slowBeat, durationOfTimer, timerObserver);
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
