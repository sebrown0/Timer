/**
 * 
 */
package heartbeat;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Steve Brown
 *
 *  Schedules a target object to be run for every beat, for the given time unit. 
 */
public class HeartBeat implements  BeatingHeart {
	
	private ScheduledExecutorService heartBeat = 
			Executors.newSingleThreadScheduledExecutor();	// Executor service to run the target.
	private long numberOfBeats = 0;							// The number of beats the target has run for.
	private long maxNumberOfBeats = Long.MAX_VALUE - 1;		// The number of beats the target can run for.
	private int initialDelay = 1;							// Initial delay for the scheduled service. 
	private int period = 1;									// Scheduled period between executing the service.
	private TimeUnit timeUnit = TimeUnit.SECONDS;			// Time Unit for the period and delay.
	public String heartBeatOwner;							// The owner of this HeartBeat.
	public String heartBeatType;							// The type of HeartBeat.
	
	public HeartBeat() {}
	
	/*
	 *  New heart beat with delay between beats and unit of delay.
	 */
	public HeartBeat(int period, TimeUnit timeUnit, String owner, String heartBeatType) {
		this.period = period;
		this.initialDelay = period;							// Make the initial delay the same as the period.
		this.timeUnit = timeUnit;
		this.heartBeatOwner = owner;
		this.heartBeatType = heartBeatType;
		System.out.println("HB -> (" + heartBeatType + ") created for: " + heartBeatOwner); // TODO - Log
	}
	
	/*
	 * (non-Javadoc)
	 * @see heartbeat.BeatingHeart#startBeating(heartbeat.Beatable)
	 */
	@Override
	public void startBeating(Beatable target) {	
		heartBeat.scheduleAtFixedRate(target, initialDelay, period,  timeUnit);
	}
	
	/*
	 * (non-Javadoc)
	 * @see heartbeat.BeatingHeart#startBeating(heartbeat.BeatingHeart, long)
	 */
	@Override
	public void startBeating(Beatable target, long maxNumberOfBeats) {
		this.maxNumberOfBeats = maxNumberOfBeats;
		heartBeat.scheduleAtFixedRate(target, initialDelay, period,  timeUnit);
	}
	
	/*
	 * (non-Javadoc)
	 * @see heartbeat.BeatingHeart#anotherBeat()
	 */
	@Override
	public void anotherBeat() {
		numberOfBeats++;
		if(numberOfBeats >= maxNumberOfBeats) {
			stopBeating();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see heartbeat.BeatingHeart#stopBeating()
	 */
	@Override
	public void stopBeating() {
		System.out.println(heartBeatOwner + " Shutting down");		// TODO - Log
		heartBeat.shutdown(); 
		try {
			heartBeat.awaitTermination(period, timeUnit);
			heartBeat.shutdown(); 
		} catch (InterruptedException e) {
			System.out.println("Error shutting down");				// TODO - Log
			heartBeat.shutdownNow();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// Beatable object should implement.
	}
	
	/*
	 * (non-Javadoc)
	 * @see heartbeat.Beatable#beat()
	 */
	@Override
	public void beat() {
		// Beatable object should implement.		
	}

	
}
	
