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
	 *  Notify any observers that the subject has changed and give the reason.
	 */
	void notifyObservers(ObserverMessage msg);
	
	/*
	 *  The number of registered observers.
	 */
	int numberOfObservers();
}
