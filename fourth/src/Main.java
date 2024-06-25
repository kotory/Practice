import java.util.List;
import java.util.Arrays;

public class Main {

    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int countNumbersInIntervals(List<Interval> intervals) {
        int totalCount = 0;

        for (Interval interval : intervals) {
            totalCount += (interval.end - interval.start);
        }

        return totalCount;
    }

    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(
                new Interval(1, 2),
                new Interval(6, 10),
                new Interval(11, 15)
        );

        int count = countNumbersInIntervals(intervals);
        System.out.println("Количество чисел между интервалами: " + count);
    }
}