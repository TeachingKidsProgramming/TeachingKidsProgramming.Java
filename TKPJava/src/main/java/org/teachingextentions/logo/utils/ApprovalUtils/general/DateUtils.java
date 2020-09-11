package utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
    private static int TIME_SCALE[] = {Calendar.YEAR,
            Calendar.MONTH,
            Calendar.DATE,
            Calendar.HOUR_OF_DAY,
            Calendar.HOUR,
            Calendar.MINUTE,
            Calendar.SECOND,
            Calendar.MILLISECOND};

    public static Calendar setSignificantDigit(Calendar calendar, int smallestUnits) {
        boolean removeOn = false;
        for (int i : TIME_SCALE) {
            if (removeOn) {
                if (i == Calendar.DATE) {
                    // Work around since this is broke
                    calendar.set(i, 1);
                } else if (i == Calendar.HOUR_OF_DAY) {
                    // Work around since this is broke
                    calendar.set(i, 0);
                } else {
                    calendar.clear(i);
                }
            }
            if (i == smallestUnits) {
                removeOn = true;
            }
        }
        return calendar;
    }

    public static void main(String args[]) {
        MySystem.variable("Calendar.DATE = " + Calendar.DATE);
        MySystem.variable("Year", setSignificantDigit(new GregorianCalendar(), Calendar.YEAR).getTime());
        MySystem.variable("Month", setSignificantDigit(new GregorianCalendar(), Calendar.MONTH).getTime());
        MySystem.variable("Day", setSignificantDigit(new GregorianCalendar(), Calendar.DAY_OF_MONTH).getTime());
        MySystem.variable("Hour", setSignificantDigit(new GregorianCalendar(), Calendar.HOUR).getTime());
        MySystem.variable("Minute", setSignificantDigit(new GregorianCalendar(), Calendar.MINUTE).getTime());
        MySystem.variable("End Of Day", rollToEndOfDay(new Date()).getTime());
    }

    public static GregorianCalendar rollToEndOfDay(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        gregorianCalendar.set(Calendar.HOUR_OF_DAY, 23);
        gregorianCalendar.set(Calendar.MINUTE, 59);
        gregorianCalendar.set(Calendar.SECOND, 59);
        gregorianCalendar.set(Calendar.MILLISECOND, 999);
        return gregorianCalendar;
    }

}