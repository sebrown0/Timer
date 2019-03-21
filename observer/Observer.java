/**
 * 
 */
package observer;

/**
 * @author Steve Brown
 *
 *  Any object that implements a timer and wants to keep in step with the timer
 *  should implement this.
 */
public interface Observer {
	
	/*
	 *  Inform any observer of the timer that the timer has ticked over 1 more time.
	 */
	void updateObserver();
	
//	void unregister(Observer observer);
}
