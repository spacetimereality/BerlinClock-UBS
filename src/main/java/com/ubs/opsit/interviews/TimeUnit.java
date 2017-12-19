package com.ubs.opsit.interviews;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.stream.IntStream;

import com.google.common.base.Strings;

public enum TimeUnit {

	FirstHourRow {
		public String format(int hour) {
			checkParameter(hour, 24);
			int redLights = hour / 5;
			return formatRow(redLights, RED_LIGHT) + (formatRow(4 - redLights, OFF));
		}
	},
	SecondHourRow {
		public String format(int hour) {
			checkParameter(hour, 24);
			int redLights = hour % 5;
			return formatRow(redLights, RED_LIGHT) + (formatRow(4 - redLights, OFF));
		}
	},
	FirstMinuteRow {
		public String format(int minute) {
			checkParameter(minute, 59);
			int yellowLights = minute / 5;
			char[] row = (formatRow(yellowLights, YELLOW_LIGHT) + formatRow(11 - yellowLights, OFF)).toCharArray();
			IntStream.iterate(2, n -> n + 3).limit(3).forEach(index -> {
				if (row[index] == YELLOW_LIGHT.charAt(0)) {
					row[index] = RED_LIGHT.charAt(0);
				}
			});
			return new String(row);
		}
	},
	SecondMinuteRow {
		public String format(int minute) {
			checkParameter(minute, 59);
			int yellowLights = minute % 5;
			return formatRow(yellowLights, YELLOW_LIGHT) + (formatRow(4 - yellowLights, OFF));
		}
	},
	SecondRow {
		public String format(int second) {
			checkParameter(second, 59);
			return second % 2 == 0 ? YELLOW_LIGHT : OFF;
		}
	};

	public abstract String format(int time);

	private static String formatRow(int count, String light) {
		return Strings.repeat(light, count);
	}

	private static void checkParameter(int timeUnit, int maxAllowed) {
		checkArgument(timeUnit >= 0 && timeUnit <= maxAllowed,
				"Argument was %s but expected nonnegative and greater than %s", timeUnit, maxAllowed);
	}

	private static final String RED_LIGHT = "R";
	private static final String YELLOW_LIGHT = "Y";
	private static final String OFF = "O";

}
