import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int SECONDS_IN_MINUTE = 60;
    private static final int SECONDS_IN_HOUR = 3600;
    private static final int SECONDS_IN_DAY = 86400;
    private static final int SECONDS_IN_WEEK = 604800;
    private static final int SECONDS_IN_YEAR = 31536000;

    private static String joinWithCommasAndAnd(List<String> parts) {
        if (parts.size() == 0) return "";
        if (parts.size() == 1) return parts.get(0);
        if (parts.size() == 2) return parts.get(0) + " и " + parts.get(1);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < parts.size() - 2; i++) {
            result.append(parts.get(i)).append(", ");
        }
        result.append(parts.get(parts.size() - 2)).append(" и ").append(parts.get(parts.size() - 1));
        return result.toString();
    }
    public static String formatDuration(int seconds) {
        if (seconds == 0) return "0 секунд";

        int years = seconds / SECONDS_IN_YEAR;
        seconds %= SECONDS_IN_YEAR;

        int weeks = seconds / SECONDS_IN_WEEK;
        seconds %= SECONDS_IN_WEEK;

        int days = seconds / SECONDS_IN_DAY;
        seconds %= SECONDS_IN_DAY;

        int hours = seconds / SECONDS_IN_HOUR;
        seconds %= SECONDS_IN_HOUR;

        int minutes = seconds / SECONDS_IN_MINUTE;
        seconds %= SECONDS_IN_MINUTE;

        List<String> parts = new ArrayList<>();

        if (years > 0) {
            parts.add(years + (years == 1 ? " год" : " года"));
        }
        if (weeks > 0) {
            parts.add(weeks + (weeks == 1 ? " неделя" : " недели"));
        }
        if (days > 0) {
            parts.add(days + (days == 1 ? " день" : " дня"));
        }
        if (hours > 0) {
            parts.add(hours + (hours == 1 ? " час" : " часа"));
        }
        if (minutes > 0) {
            parts.add(minutes + (minutes == 1 ? " минута" : " минуты"));
        }
        if (seconds > 0) {
            parts.add(seconds + (seconds == 1 ? " секунда" : " секунды"));
        }

        return joinWithCommasAndAnd(parts);
    }

    public static void main(String[] args) {
        System.out.println(formatDuration(62));
        System.out.println(formatDuration(3662));
        System.out.println(formatDuration(0));
        System.out.println(formatDuration(31536000));
        System.out.println(formatDuration(31536162));
    }
}
