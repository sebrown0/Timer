/**
 * 
 */
package heartbeat;

/**
 * @author Steve Brown
 *
 *  Implements a slow heart beat.
 */
public class SlowHeartbeat extends HeartBeat implements SlowBeat{

	/*
	 *  A SlowHeartbeat (1 fixed period) of whatever the SlowBeat.timeUnit is. 
	 */
	public SlowHeartbeat(String owner) {
		super(1, SlowBeat.timeUnit, owner, "SlowHeartBeat" );
	}
}
