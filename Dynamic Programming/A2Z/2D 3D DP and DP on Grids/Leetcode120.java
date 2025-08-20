
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode120 {

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return solve(triangle, 0, 0, dp);
    }

    public static int solve(List<List<Integer>> triangle, int row, int col, int dp[][]) {
        int n = triangle.size();
        if (row == n - 1) {
            return triangle.get(row).get(col);
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        int down = solve(triangle, row + 1, col, dp);
        int diagonal = solve(triangle, row + 1, col + 1, dp);

        dp[row][col] = triangle.get(row).get(col) + Math.min(down, diagonal);
        return dp[row][col];
    }

    //Bottom-Up Approach
    public static int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        // base case: last row = same as triangle last row
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }

        // build dp table from bottom to top
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                dp[row][col] = triangle.get(row).get(col)
                        + Math.min(dp[row + 1][col], dp[row + 1][col + 1]);
            }
        }

        // answer is at the top
        return dp[0][0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        int result = minimumTotal(triangle);
        System.out.println("Minimum Path Sum = " + result);  // Expected: 11
        System.out.println(minimumTotal2(triangle));
    }
}
