package running_time;

import timer.Timer;

public class FastTimerRunningTime extends RunningTime{

	public FastTimerRunningTime(Timer timer, long timerDuration) {
		super(timer, timerDuration);
	}
	
	@Override
	public int runTimerForDuration() {
		timerStartTime = timer.currentTime() / 1000;
		timer.startTimer();
		while(notTimeToStopTimer(timer.currentTime() / 1000)) {
			System.out.println(); // Have to do this to make the test work!
		}
		timer.stopTimer();
		return timer.currentTime() / 1000;
	}

}
