/**
 * 
 */
package timer;

import heartbeat.Beatable;
import heartbeat.BeatingHeart;
import observer.GenericSubject;
import observer.Observer;
import observer.ObserverMessage;
import observer.Subject;
import time.MutableTime;

/**
 * @author Steve Brown
 *
 *  A timer that runs with a HeartBeat.
 *  The timer ticks forward with an interval, measured in a unit specified by the HeartBeat. 
 *  
 *  The heart beat in turn is specified by the implementation of the timer.
 *  If the Timer has a registered observer it will notify the observer(s)
 *  of a 'tick' or that the Timer is stopping.
 */
public abstract class Timer implements  Timers, Beatable{
	
	protected MutableTime time = null;				// We need a changeable time for a timer.
	protected BeatingHeart heartBeat = null;		// A heart beat to represent a 'tick'.
	private long durationOfTimer = 0;				// How long should this timer run for.
	private boolean timerRunning = false;			// Is the timer running.
	private Subject thisTimer = null;				// This Timer is the subject of an observer(s).
	private Observer ourObserver = null;			// Any object interested in us.

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
	 *  New Timer with a starting time, duration, heart beat to make it tick and an observer.
	 */
	public Timer(MutableTime time, BeatingHeart heartBeat, TimerDurationSeconds durationOfTimer, Observer timerObserver) {
		this.time = time;
		this.heartBeat = heartBeat;
		this.durationOfTimer = durationOfTimer.getDuration();
		this.thisTimer = new GenericSubject("Timer");
		this.ourObserver = timerObserver;
		thisTimer.registerObserver(ourObserver);
	}
	
	/*
	 *  Check if the Timer has a valid duration.
	 *  If it does decrement the duration and stop the timer if necessary.
	 */
	private void checkDuration() {
		// See if a valid duration was supplied with the Timer.
		if(durationOfTimer > 0) {
			// There was a valid duration. See if the Timer should now be stopped after this beat.
			if(--durationOfTimer <= 0) {
				stopTimer();	
			}
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see heartbeat.BeatingHeart#beat()
	 */
	@Override
	public void beat() {
		if(timerRunning) {
			incrementTimer();			// Increment this timer's measurement of time.
		
			if(thisTimer != null) {		// Subject of observer(s)?
				thisTimer.notifyObservers(ObserverMessage.CHANGED);
			}
			
			checkDuration();			// See if the Timer has reached the end of it's life.
		}
	}
	
	/*
	 *  Return the heart beat for this timer.
	 */
	@Override
	public BeatingHeart heartBeat() {
		return heartBeat;
	}
	
	/*
	 *  Set the observer for this timer.
	 */
	@Override
	public void setObserver(Observer o) {
		this.ourObserver = o;	
	}
	
	/*
	 * (non-Javadoc)
	 * @see timer.Timers#startTimer()
	 */
	@Override
	public void startTimer() {	
		timerRunning = true;
		if(durationOfTimer <= 0 ) {
			if(thisTimer != null) {
				heartBeat.startBeating(this, ourObserver);
			}else {
				heartBeat.startBeating(this);
			}
		} else {
			if(thisTimer != null) {
				heartBeat.startBeating(this, durationOfTimer, ourObserver);
			}else {
				heartBeat.startBeating(this, durationOfTimer);
			}
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
		if(thisTimer != null) {
			System.out.println("Notifying from (Timer)");
			thisTimer.notifyObservers(ObserverMessage.STOPPING);
		}
	}
		
	/*
	 *  Return the time for this timer.
	 */
	@Override
	public MutableTime time() {
		return time;
	}
	
	/*
	 *  Check to see if the timer is running.
	 */
	@Override
	public boolean timerRunning() {
		return timerRunning;
	}	
}
