/**
 * 
 */
package heartbeat;

import java.util.concurrent.TimeUnit;

import timer.DurationInSeconds;

/**
 * @author Steve Brown
 *
 *  Give this to an object that requires a heart beat.
 */
public interface BeatingHeart extends Beatable{
	
	/*
	 *  Execute the Beatable target.
	 *  Keeps going until told to shut down (stopBeating).
	 */
	void startBeating(Beatable target);
	
	/*
	 *  Execute the Beatable target.
	 *  Keeps going until told to shut down (stopBeating) or maxNumberOfBeats are reached.
	 */
	void startBeating(Beatable target, long maxNumberOfBeats);
		
	/*
	 *  Increment the number of heart beats.
	 */
	void anotherBeat();
	
	/*
	 *  Shutdown the heart beat and therefore the target. 
	 */
	void stopBeating();
	
	/*
	 *  Get a new HeartBeat with the time unit (period between beats) specified by timeUnit.
	 */
	default HeartBeat getBeat(TimeUnit timeUnit, String owner, String beatType) {
		return new HeartBeat(1, timeUnit, owner, beatType);
	}

}
