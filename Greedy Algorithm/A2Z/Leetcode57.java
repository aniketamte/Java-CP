
import java.util.ArrayList;
import java.util.List;

public class Leetcode57 {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        while (i < intervals.length) {
            if (intervals[i][1] < newInterval[0]) {
                i++;
            } else if (intervals[i][0] > newInterval[1]) {
                List<int[]> result = new ArrayList<>();
                for (int j = 0; j < i; j++) {
                    result.add(intervals[j]);
                }
                result.add(newInterval);
                for (int j = i; j < intervals.length; j++) {
                    result.add(intervals[j]);
                }
                return result.toArray(new int[result.size()][]);
            } else {
                // Overlap: merge them
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                List<int[]> tempList = new ArrayList<>();
                for (int j = 0; j < intervals.length; j++) {
                    if (j != i) {
                        tempList.add(intervals[j]);
                    }
                }
                intervals = tempList.toArray(new int[tempList.size()][]);
            }
        }
        List<int[]> result = new ArrayList<>();
        for (int[] interval : intervals) {
            result.add(interval);
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int intervals[][] = {
            {1, 3},
            {6, 9}
        };
        int newInterval[] = {2, 5};
        System.out.println(insert(intervals, newInterval));
    }
}
