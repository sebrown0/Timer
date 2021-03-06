/**
 * 
 */
package timer;

import heartbeat.FastBeat;
import heartbeat.FastHeartbeat;
import heartbeat.SlowBeat;
import observer.Observer;
import time.MutableTime;

/**
 * @author Steve Brown
 *  
 *  A Fast Timer implementation of a Timer
 *  It must have a fast heart beat.
 */
public class FastTimer extends Timers implements Timer {

	/*
	 *  New fast timer without a specified duration.
	 */
	public FastTimer(MutableTime time, FastBeat fastBeat, String owner) {		
		super(time, fastBeat.getBeat(FastBeat.timeUnit, owner, "FastTimer"));
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
	 *  New fast timer with a specified duration.
	 */
	public FastTimer(MutableTime time, TimerDurationSeconds durationOfTimer, String owner) {		
		super(time, new FastHeartbeat(owner).getBeat(FastBeat.timeUnit, owner, "FastTimer"), durationOfTimer);
	}
	
	/*
	 * (non-Javadoc)
	 * @see timer.FastTimer#currentTime()
	 */
	@Override
	public int currentTime() {
		return (super.time().currentTime() * 1000);		// TODO - Check this.
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
