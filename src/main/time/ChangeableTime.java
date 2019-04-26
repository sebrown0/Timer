/**
 * 
 */
package time;

/**
 * @author Steve Brown
 * 
 *  Holds a time specified at instantiation.
 *  	Time is either in seconds, i.e. 60s = 00:01:00.
 *  	Or in 3 integers representing the H:M:S.
 *   
 *  The time can be incremented by calling one of the increment methods.
 */
public class ChangeableTime extends Time implements MutableTime {


	private int hoursElasped = 0;			// The elapsed hours since the object was instantiated.
	private int minutesElasped = 0;			// The elapsed minutes since the object was instantiated.
	private int secondsElasped = 0;			// The elapsed seconds since the object was instantiated.
	private int milliSecondsElasped = 0;	// The elapsed milliseconds since the object was instantiated.
	
	/*
	 *  Construct with a Time specified in seconds.
	 */
	public ChangeableTime(int timeSeconds) {
		super(timeSeconds);
	}
	
	/*
	 *  Construct a Time with specified H,M,S.
	 */
	public ChangeableTime(int hours, int minutes, int seconds) {
		super(hours, minutes, seconds);
	}

	
	/*
	 * 	(non-Javadoc)
	 * @see time.Time#milliSeconds()
	 */
	@Override
	public int milliSeconds() {
		return milliSecondsElasped;
	}
	
	/*
	 * (non-Javadoc)
	 * @see time.Time#seconds()
	 */
	@Override
	public int seconds() {
		return secondsElasped;
	}

	/*
	 * (non-Javadoc)
	 * @see time.Time#minutes()
	 */
	@Override
	public int minutes() {
		return minutesElasped;
	}
	
	/*
	 * (non-Javadoc)
	 * @see time.Time#hours()
	 */
	@Override
	public int hours() {
		return hoursElasped;
	}
		
	/*
	 * (non-Javadoc)
	 * @see time.MutableTime#currentTime()
	 */
	@Override
	public int currentTime() {
		return currentTimeSeconds;
	}

	/*
	 * (non-Javadoc)
	 * @see time.MutableTime#incrementMilliSeconds()
	 */
	@Override
	public void incrementMilliSeconds() {
		milliSecondsElasped++;
		milliSeconds++;
		if(milliSeconds > 999) {
			milliSeconds = 0;
			incrementSeconds();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see time.MutableTime#incrementSeconds()
	 */
	@Override
	public void incrementSeconds() {
		
		currentTimeSeconds++;
		secondsElasped++;
		seconds++;				// TODO - Remove ??
		
		if(seconds > 59) {
			seconds = 0;
			minutes++;
			minutesElasped++;
			if(minutes > 59) {
				minutes = 0;
				hours++;
				hoursElasped++;
				if(hours > 23) {
					hours = 0;
				}
			}
		}
	}
}
