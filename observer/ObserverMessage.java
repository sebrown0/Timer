/**
 * 
 */
package observer;

/**
 * @author Steve Brown
 *
 *  A message to the observer.
 */
public enum ObserverMessage {

	CHANGED, 	// The subject has changed state.
	DO_WORK,	// The observer(s) should do some work.
	STOPPING;	// The subject is stopping.
}
