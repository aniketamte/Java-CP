
import java.util.*;

public class Leetcode2965 {

    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        Set<Integer> set = new HashSet<>();
        int a = 0, b = 0;
        //Find repeated Number
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (set.contains(grid[i][j])) {
                    a = grid[i][j];
                }
                set.add(grid[i][j]);
            }
        }

        //Find missing number
        for (int i = 1; i <= n * n; i++) {

            if (!set.contains(i)) {
                b = i;
                break;
            }
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        int grid[][] = {
            {1, 3},
            {2, 2}
        };
        System.out.println(findMissingAndRepeatedValues(grid));
    }
}
