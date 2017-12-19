package com.ubs.opsit.interviews;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BerlinClockTest {

	private BerlinClock berlinClock;

	@Before
	public void setUp() throws Exception {
		berlinClock = new BerlinClock();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNullParameter() throws Exception {
		berlinClock.convertTime(null);
	}

	@Test(expected = IllegalArgumentException.class)
	@Ignore
	public void testEmptyParameter() throws Exception {
		berlinClock.convertTime("");
	}

	@Test(expected = IllegalArgumentException.class)
	@Ignore
	public void testInvalidHour() {
		berlinClock.convertTime("25:46:54");
	}

	@Test(expected = IllegalArgumentException.class)
	@Ignore
	public void testInvalidMinute() {
		berlinClock.convertTime("15:75:54");
	}

}
