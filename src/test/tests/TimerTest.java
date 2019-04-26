package tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import heartbeat.FastBeat;
import heartbeat.FastHeartbeat;
import heartbeat.SlowBeat;
import heartbeat.SlowHeartbeat;
import running_time.FastTimerRunningTime;
import running_time.SlowTimerRunningTime;
import running_time.TimerRunningTime;
import time.ChangeableTime;
import time.MutableTime;
import timer.DurationInSeconds;
import timer.FastTimer;
import timer.SlowTimer;
import timer.Timer;
import timer.TimerDurationSeconds;

class TimerTest {

	private SlowBeat slowHB;
	private FastBeat fastHB;
	private MutableTime mutableTime;
	private Timer slowTimer;
	private Timer fastTimer;
	private TimerDurationSeconds duration;

	private static int TIMER_DURATION;
	private static int HH = 12;
	private static int MM = 10;
	private static int SS = 12;
	private static String START_TIME;

	@BeforeEach
	void setUp() {
		TIMER_DURATION = 1;
		START_TIME = String.valueOf(HH) + ":" + String.valueOf(MM) + ":" + String.valueOf(SS);

		slowHB = new SlowHeartbeat("SlowHB Test");
		fastHB = new FastHeartbeat("FastHB Test");
		mutableTime = new ChangeableTime(HH, MM, SS);
		duration = new DurationInSeconds(TimeUnit.SECONDS, TIMER_DURATION);
		slowTimer = new SlowTimer(mutableTime, slowHB, "Slow Timer Test");
		fastTimer = new FastTimer(mutableTime, fastHB, "Fast Timer Test");
	}

	@Test
	void testSetUp() {
		assertNotNull("Failed to create  slowHB", slowHB);
		assertNotNull("Failed to create fastHB", fastHB);
		assertNotNull("Failed to create  mutableTime", mutableTime);
		assertNotNull("Failed to create duration", duration);
		assertNotNull("Failed to create slowTimer", slowTimer);
		assertNotNull("Failed to create fastTimer", fastTimer);
		assertEquals(TIMER_DURATION, duration.getDuration());
	}

	@Test
	void correctTimeInt() {
		assertEquals(calculateTimeInSeconds(), mutableTime.currentTime());
	}

	@Test
	void correctTimeFormatted() {
		assertEquals(START_TIME, mutableTime.formattedTime());
	}

	@Test
	void slowTimer() {
		TimerRunningTime trt = new SlowTimerRunningTime(slowTimer, TIMER_DURATION);
		assertEquals(TIMER_DURATION, trt.runTimerForDuration() - trt.timerStartTime());
	}

	@Test
	void fastTimer() {
		TimerRunningTime trt = new FastTimerRunningTime(fastTimer, TIMER_DURATION);
		assertEquals(TIMER_DURATION, trt.runTimerForDuration() - trt.timerStartTime());
	}

	private int calculateTimeInSeconds() {
		return (HH*3600) + (MM*60) + SS;
	}
}
