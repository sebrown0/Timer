/**
 * 
 */
package heartbeat;

import java.util.concurrent.TimeUnit;

/**
 * @author Steve Brown
 *
 *  Forces an implementation of a heart beat to have a fast beat, i.e. every 1ms.
 */
public interface FastBeat extends BeatingHeart {

	static TimeUnit timeUnit = TimeUnit.MILLISECONDS;
	
	/* 
	 *  Get the time unit that was used for this instance of HeartBeat.
	 */
	default TimeUnit getTimeUnit() {
		return timeUnit; 
	}
}
