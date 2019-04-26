/**
 * 
 */
package heartbeat;

/**
 * @author Steve Brown
 *
 *  Implements a fast heart beat.
 */
public class FastHeartbeat extends HeartBeat implements FastBeat{

	/*
	 *  A FastHeartbeat (1 fixed period) of whatever the FastBeat.timeUnit is. 
	 */
	public FastHeartbeat(String owner) {
		super(1, FastBeat.timeUnit, owner, "FastHeartBeat");
	}

}
