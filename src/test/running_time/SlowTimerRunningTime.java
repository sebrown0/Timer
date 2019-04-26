package running_time;

import timer.Timer;

public class SlowTimerRunningTime extends RunningTime{

	public SlowTimerRunningTime(Timer timer, long timerDuration) {
		super(timer, timerDuration);
	}
	
	@Override
	public int runTimerForDuration() {
		timerStartTime = timer.currentTime();
		timer.startTimer();
		while(notTimeToStopTimer(timer.currentTime())) {
			System.out.println(); // Have to do this to make the test work!
		}
		timer.stopTimer();
		return timer.currentTime();
	}

}
