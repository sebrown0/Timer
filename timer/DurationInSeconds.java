/**
 * 
 */
package timer;

import java.util.concurrent.TimeUnit;

/**
 * @author Steve Brown
 * 
 *  Should always return a lengthOfDuration in seconds
 *  no matter what lengthOfDuration and unit of lengthOfDuration is given.
 *  
 */
public final class DurationInSeconds implements TimerDurationSeconds {
	
	private static long duration = 0;

	/*
	 * 	timeUnit: the unit of time for the duration, i.e. MINUTE.
	 * 	lengthOfDuration: how long is the duration.
	 */
	public DurationInSeconds(TimeUnit timeUnit, long lengthOfDuration) {
		setDuration(timeUnit, lengthOfDuration);
	}
	
	private static void setDuration(TimeUnit timeUnit, long lengthOfDuration) {
		switch (timeUnit) {
		case DAYS:
			duration = lengthOfDuration * 86400;
			break;

		case HOURS:
			duration = lengthOfDuration * 3600;
			break;
			
		case MINUTES:
			duration = lengthOfDuration * 60;
			break;
			
		case SECONDS:
			duration = lengthOfDuration;
			break;
			
		default:
			break;
		}
		
		// Check to see that the number is valid.
		duration = (duration < 0 || duration > Long.MAX_VALUE) ? 0 : duration;
		System.out.println("Duration: " + duration);
	}

	/*
	 * (non-Javadoc)
	 * @see timer.TimerDurationSeconds#getDuration()
	 */
	@Override
	public long getDuration() {
		return duration;
	}
	
}
