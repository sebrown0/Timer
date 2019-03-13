/**
 * 
 */
package heartbeat;

import java.util.concurrent.TimeUnit;

/**
 * @author Steve Brown
 *
 *  Implements a fast heart beat.
 */
public class FastHeartbeat extends HeartBeat implements FastBeat{

	/*
	 * (non-Javadoc)
	 * @see heartbeat.FastBeat#getTimeUnit()
	 */
	@Override
	public TimeUnit getTimeUnit() {
		return timeUnit;
	}
}
