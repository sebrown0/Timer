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
 *  The time is immutable.
 */
public class Time implements ImmutableTime {

	protected int hours = 0;
	protected int minutes = 0;
	protected int seconds = 0;
	protected int milliSeconds = 0;				
	protected int currentTimeSeconds = 0;		// The current time. Incremented when used as a counter/timer.

	private int givenTimeSeconds = 0;			// The time the object was initialised with.
	
	/*
	 *  Construct with a Time specified in seconds.
	 */
	public Time(int currentTimeSeconds) {
		this.currentTimeSeconds = (currentTimeSeconds >= 0) ? currentTimeSeconds : 0;
		this.givenTimeSeconds = currentTimeSeconds;
	}
	
	/*
	 *  Construct a Time with specified H,M,S.
	 */
	public Time(int hours, int minutes, int seconds) {
		// Check the H,M,S are legal. Convert into seconds.
		this.currentTimeSeconds = checkTime(hours, minutes, seconds);
		if(currentTimeSeconds >= 0) {
			this.hours = hours;
			this.minutes = minutes;
			this.seconds = seconds;
			this.givenTimeSeconds = currentTimeSeconds;
		}
	}
	
	/*
	 *  Check if the specified time is legal.
	 *  An illegal parameter is set to 0. 
	 */
	private int checkTime (int hours, int minutes, int seconds) {
		seconds = (seconds >= 0 && seconds <= 60) ? seconds: 0;
		minutes = (minutes >= 0 && minutes <= 60) ? minutes: 0;
		hours = (hours >= 0 && hours <= 24) ? hours: 0;
		
		return getTimeInSeconds(hours, minutes, seconds);
	}
	
	/*
	 *  Prepend a 0 to the digit if required.
	 */
	private String formatDigit(int digit) {
		String value = String.valueOf(digit);
		
		return (digit < 10) ? "0" + value : value; 
	}
	
	/*
	 * (non-Javadoc)
	 * @see time.ImmutableTime#formattedTime()
	 */
	@Override
	public String formattedTime() {
		return formatDigit(hours) + ":" + formatDigit(minutes) + ":" + formatDigit(seconds);
	}
	
	/*
	 * (non-Javadoc)
	 * @see time.ImmutableTime#getTimeInSeconds(int, int, int)
	 */
	@Override
	public int getTimeInSeconds(int hours, int minutes, int seconds) {
		return ((hours * 3600) + (minutes * 60) + seconds);
	}

	/*
	 * (non-Javadoc)
	 * @see time.ImmutableTime#milliSeconds()
	 */
	@Override
	public int milliSeconds() {
		return milliSeconds;
	}

	/*
	 * (non-Javadoc)
	 * @see time.ImmutableTime#seconds()
	 */
	@Override
	public int seconds() {
		return seconds;
	}

	/*
	 * (non-Javadoc)
	 * @see time.ImmutableTime#minutes()
	 */
	@Override
	public int minutes() {
		return minutes;
	}

	/*
	 * (non-Javadoc)
	 * @see time.ImmutableTime#hours()
	 */
	@Override
	public int hours() {
		return hours;
	}

	/*
	 * (non-Javadoc)
	 * @see time.ImmutableTime#givenTimeSeconds()
	 */
	@Override
	public int givenTimeSeconds() {
		return givenTimeSeconds;
	}
}
