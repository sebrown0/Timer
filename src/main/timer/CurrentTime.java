package timer;

public interface CurrentTime {

	/*
	 *  Return the current time as HH:MM:SS.
	 */
	String currentTimeFormatted();
	

	/*
	 *  Get the current time in the unit specified by the implementation.
	 *  For example if it's a slow timer the current time will be returned in seconds.
	 */
	int currentTime(); 
}
