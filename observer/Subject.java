/**
 * 
 */
package observer;

/**
 * @author Steve Brown
 *
 *  Use if an object is going to be observed by another object (Observer Pattern).
 */
public interface Subject {

	/*
	 *  Register the observer.
	 */
	void registerObserver(Observer observer);
	
	/*
	 *  Unregister the observer.
	 */
	void unregisterObserver(Observer observer);
	
	/*
	 *  Notify any observers that the subject has changed.
	 */
	void notifyObservers();
	
	/*
	 *  The number of registered observers.
	 */
	int numberOfObservers();
}
