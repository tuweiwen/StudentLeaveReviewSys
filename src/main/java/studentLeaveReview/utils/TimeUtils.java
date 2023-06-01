package studentLeaveReview.utils;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {
    public static Date timeStringProcess(String time) {
        System.out.println("-----StudentController.timeStringProcess-----");
        int[] timePart = Arrays.stream(time.replace("T", "-").replace(":", "-").split("-")).mapToInt(Integer::parseInt).toArray();
        Calendar c = Calendar.getInstance();
        c.set(timePart[0], timePart[1], timePart[2], timePart[3], timePart[4]);
        return c.getTime();
    }

    public static String timeDateProcess(Date time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        return calendar.get(Calendar.YEAR) +
                "-" +
                intToString(calendar.get(Calendar.MONTH) + 1) +
                "-" +
                intToString(calendar.get(Calendar.DAY_OF_MONTH)) +
                "T" +
                intToString(calendar.get(Calendar.HOUR_OF_DAY)) +
                ":" +
                intToString(calendar.get(Calendar.MINUTE));
    }

    static String intToString(int value) {
        if (value >= 10) {
            return String.valueOf(value);
        } else {
            return "0" + value;
        }
    }
}
