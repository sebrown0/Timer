package running_time;

import timer.Timer;

public abstract class RunningTime implements TimerRunningTime{

	protected Timer timer;
	protected long timerDuration;
	protected int timerStartTime;
	
	public RunningTime(Timer timer, long timerDuration) {
		this.timer = timer;
		this.timerDuration = timerDuration;
	}
	
	protected boolean notTimeToStopTimer(int currentTime) {
		return (currentTime >= (timerStartTime + timerDuration) && timer.timerRunning()) ? false : true;
	}
	
	@Override
	public int timerStartTime() {
		return timerStartTime;
	}
	
}
