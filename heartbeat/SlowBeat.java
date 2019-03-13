/**
 * 
 */
package heartbeat;

import java.util.concurrent.TimeUnit;

/**
 * @author Steve Brown
 *
 *  Forces an implementation of a heart beat to have a slow beat, i.e. every 1s.
 */
public interface SlowBeat extends BeatingHeart {
	
	static TimeUnit timeUnit = TimeUnit.SECONDS;
	
	/* 
	 *  Get the time unit that was used for this instance of HeartBeat.
	 */
	TimeUnit getTimeUnit();
}
