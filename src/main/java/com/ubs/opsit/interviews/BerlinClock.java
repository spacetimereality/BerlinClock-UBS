package com.ubs.opsit.interviews;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;

public class BerlinClock implements TimeConverter {

	public String convertTime(String aTime) {
		checkArgument(!Strings.isNullOrEmpty(aTime), "Input cannot be emptry string or null");
		Pattern pattern = Pattern.compile("([01]?[0-9]|2[0-4]):([0-5][0-9]):([0-5][0-9])");
		Matcher matcher = pattern.matcher(aTime);
		if (matcher.matches()) {
			Joiner joiner = Joiner.on(System.lineSeparator()).skipNulls();
			return joiner.join(TimeUnit.SecondRow.format(Integer.parseInt(matcher.group(3))),
					TimeUnit.FirstHourRow.format(Integer.parseInt(matcher.group(1))),
					TimeUnit.SecondHourRow.format(Integer.parseInt(matcher.group(1))),
					TimeUnit.FirstMinuteRow.format(Integer.parseInt(matcher.group(2))),
					TimeUnit.SecondMinuteRow.format(Integer.parseInt(matcher.group(2))));
		}
		throw new IllegalArgumentException("Invalid time format :" + aTime);
	}
}