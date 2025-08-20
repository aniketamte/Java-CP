
import java.util.Arrays;

public class Leetcode931 {

    static int n;

    public static int minFallingPathSum(int[][] matrix) {
        n = matrix.length;
        int row = 0;
        int result = Integer.MAX_VALUE;
        int dp[][] = new int[n][n];

        for (int rows[] : dp) {
            Arrays.fill(rows, -1);
        }

        for (int col = 0; col < n; col++) {
            result = Math.min(result, solve(matrix, row, col, dp));
        }
        return result;
    }

    public static int solve(int matrix[][], int row, int col, int dp[][]) {
        if (row == n - 1) {
            return matrix[row][col];
        }
        int sum = matrix[row][col];
        int minSum = Integer.MAX_VALUE;

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        if (row + 1 < n && col - 1 >= 0) {
            minSum = Math.min(minSum, sum + solve(matrix, row + 1, col - 1, dp));
        }

        if (row + 1 < n) {
            minSum = Math.min(minSum, sum + solve(matrix, row + 1, col, dp));
        }

        if (row + 1 < n && col + 1 < n) {
            minSum = Math.min(minSum, sum + solve(matrix, row + 1, col + 1, dp));
        }

        return minSum;
    }

    //Bottom-Up Approach
    public static int minFallingPathSum2(int[][] matrix) {
        int n = matrix.length;
        int[] prev = new int[n];

        // Initialize the first row of prev array
        for (int col = 0; col < n; col++) {
            prev[col] = matrix[0][col];
        }

        // Iterate over the remaining rows
        for (int row = 1; row < n; row++) {
            int[] curr = new int[n];
            for (int col = 0; col < n; col++) {
                curr[col] = matrix[row][col] + Math.min(Math.min(prev[Math.max(0, col - 1)], prev[col]), prev[Math.min(n - 1, col + 1)]);
            }
            prev = curr;
        }

        // Return the minimum element in the last row of the dp array
        int minPathSum = Integer.MAX_VALUE;
        for (int value : prev) {
            minPathSum = Math.min(minPathSum, value);
        }

        return minPathSum;
    }

    public static void main(String[] args) {
        int matrix[][] = {
            {2, 1, 3},
            {6, 5, 4},
            {7, 8, 9}
        };
        System.out.println(minFallingPathSum(matrix));
        System.out.println(minFallingPathSum2(matrix));
    }
}
