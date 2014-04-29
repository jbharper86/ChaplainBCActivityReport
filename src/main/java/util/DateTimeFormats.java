package util;

import org.joda.time.format.*;

public class DateTimeFormats {

	public static final DateTimeFormatter YEAR_MONTH_DAY_FORMAT = DateTimeFormat.forPattern("yyyy_MM_dd");

	public static final PeriodFormatter HOUR_MIN_PERIOD_FORMAT = new PeriodFormatterBuilder().printZeroAlways().appendHours().appendLiteral(
			" HR ").appendMinutes().appendLiteral(" MIN").toFormatter();

	public static final DateTimeFormatter MONTH_DAY_YEAR_FORMAT = new DateTimeFormatterBuilder().appendMonthOfYearText().appendLiteral(
			" ").appendDayOfMonth(1).appendLiteral(", ").appendYear(4, 4).toFormatter();
	public static final DateTimeFormatter MONTH_YEAR_FORMAT = new DateTimeFormatterBuilder().appendMonthOfYearText().appendLiteral(
			" ").appendYear(4, 4).toFormatter();
	public static final DateTimeFormatter HOUR_MIN_TIME_FORMAT = new DateTimeFormatterBuilder().appendHourOfDay(1).appendLiteral(
			":").appendMinuteOfHour(2).toFormatter();
}
