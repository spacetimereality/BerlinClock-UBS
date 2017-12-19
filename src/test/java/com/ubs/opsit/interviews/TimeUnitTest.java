package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TimeUnitTest {


	@Test(expected=IllegalArgumentException.class)
	public void testFirstHourRowNegativeInput() {
		TimeUnit.FirstHourRow.format(-1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFirstHourRowLargeInput() {
		TimeUnit.FirstHourRow.format(25);

	}
	
	@Test
	public void testFirstHourRowWithOutRedIndexes() {
		assertEquals("OOOO",TimeUnit.FirstHourRow.format(0));
	}
	
	@Test
	public void testFirstHourRowWithRedIndexes() {
		assertEquals("RROO",TimeUnit.FirstHourRow.format(14));
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testSecondHourRowNegativeInput() {
		TimeUnit.SecondHourRow.format(-1);

	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSecondHourRowLargeInput() {
		TimeUnit.SecondHourRow.format(26);

	}
	
	@Test
	public void testSecondHourRowWithoutRedIndexes() {
		assertEquals("OOOO", TimeUnit.SecondHourRow.format(15));
	}
	
	@Test
	public void testSecondHourRowWithRedIndexes() {
		assertEquals("RRRR", TimeUnit.SecondHourRow.format(14));
	}
	

	@Test(expected=IllegalArgumentException.class)
	public void testFirstMinuteRowNegativeInput() {
		TimeUnit.FirstMinuteRow.format(-1);

	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFirstMinuteRowLargeInput() {
		TimeUnit.FirstMinuteRow.format(60);

	}
	
	@Test
	public void testFirstMinuteRowWithRedIndexes() {
		assertEquals("YYRYYRYYRYY",TimeUnit.FirstMinuteRow.format(58));
	}
	
	@Test
	public void testFirstMinuteRowWithoutRedIndexes() {
		assertEquals("YOOOOOOOOOO",TimeUnit.FirstMinuteRow.format(9));
	}	
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testSecondMinuteRowNegativeInput() {
		TimeUnit.SecondMinuteRow.format(-1);

	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSecondMinuteRowLargeInput() {
		TimeUnit.SecondMinuteRow.format(60);
	}
	
	@Test
	public void testSecondMinuteRowWithOutYellowIndexes() {
		assertEquals("OOOO",TimeUnit.SecondMinuteRow.format(10));
	}
	
	@Test
	public void testSecondMinuteRowWithYellowIndexes() {
		assertEquals("YYYO",TimeUnit.SecondMinuteRow.format(8));
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testSecondRowNegativeInput() {
		TimeUnit.SecondRow.format(-1);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSecondRowLargeInput() {
		TimeUnit.SecondRow.format(60);
	}
	
	@Test
	public void testSecondRowForEvenSeconds() {
		assertEquals("Y",TimeUnit.SecondRow.format(2));
	}
	
	@Test
	public void testSecondRowForOddSeconds() {
		assertEquals("O",TimeUnit.SecondRow.format(1));
	}

	
}
