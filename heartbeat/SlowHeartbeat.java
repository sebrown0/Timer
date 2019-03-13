/**
 * 
 */
package heartbeat;

import java.util.concurrent.TimeUnit;

/**
 * @author Steve Brown
 *
 *  Implements a slow heart beat.
 */
public class SlowHeartbeat extends HeartBeat implements SlowBeat{

	/*
	 * (non-Javadoc)
	 * @see heartbeat.SlowBeat#getTimeUnit()
	 */
	@Override
	public TimeUnit getTimeUnit() {
		return timeUnit;
	}
}
