package xyz.nowaha.nlib.utils;

import javax.annotation.Nonnull;
import java.util.Date;

public class TimeUtils {

    private static final long MS_IN_SECOND = 1000;
    private static final long MS_IN_MINUTE = MS_IN_SECOND * 60;
    private static final long MS_IN_HOUR = MS_IN_MINUTE * 60;
    private static final long MS_IN_DAY = MS_IN_HOUR * 24;

    public static String timeDifferenceToString(@Nonnull Date first, @Nonnull Date second) {
        long difference = second.getTime() - first.getTime();
        if (difference < 0) throw new IllegalArgumentException("Second date must be after first date.");

        int days = (int) Math.floor(difference / (double) MS_IN_DAY);
        int hours = (int) Math.floor((difference - (days * MS_IN_DAY)) / (double) MS_IN_HOUR);
        int minutes = (int) Math.floor((difference - (days * MS_IN_DAY) - (hours * MS_IN_HOUR)) / (double) MS_IN_MINUTE);
        int seconds = (int) Math.floor((difference - (days * MS_IN_DAY) - (hours * MS_IN_HOUR) - (minutes * MS_IN_MINUTE)) / (double) MS_IN_SECOND);

        StringBuilder result = new StringBuilder();
        if (days > 0) result.append(days).append("d, ");
        if (hours > 0 || days > 0) result.append(hours).append("h, ");
        if (minutes > 0 || days > 0 || hours > 0) result.append(minutes).append("m, ");
        result.append(seconds).append("s");

        return result.toString();
    }

}
