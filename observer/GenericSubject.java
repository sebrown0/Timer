/**
 * 
 */
package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Steve Brown
 *
 */
public class GenericSubject implements Subject {

	private List<Observer> observers;		// A list of observers, observing the subject.
	private int numberOfObservers = 0;		// The number of registered observers.
	
	public GenericSubject() {
		observers = new ArrayList<>();
	}
	
	@Override
	public void registerObserver(Observer o) {
		this.observers.add(o);
		numberOfObservers++;
	}

	@Override
	public void unregisterObserver(Observer o) {
		for (Observer observer : observers) {
			if(observer == o) {
				observers.remove(o);
				numberOfObservers--;
				System.out.println("Removed observer"); // TODO - Remove/Log
			}
		}
	}

	@Override
	public void notifyObservers() {
		for (Observer o : observers) {
			o.updateObserver();
		}
	}

	@Override
	public void notifyObservers(ObserverMessage msg) {
		for (Observer o : observers) {
			o.updateObserver(msg);
		}
	}

	@Override
	public int numberOfObservers() {
		return numberOfObservers;
	}	
}
