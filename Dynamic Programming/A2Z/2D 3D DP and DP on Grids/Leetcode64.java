
import java.util.Arrays;

public class Leetcode64 {
      public static int solve(int grid[][], int i, int j, int m, int n, int dp[][]) {
            if (i == m - 1 && j == n - 1) {
                  return grid[i][j];
            }

            if (dp[i][j] != -1) {
                  return dp[i][j];
            }

            if (i == m - 1) {
                  // last row --> only go right
                  return dp[i][j] = grid[i][j] + solve(grid, i, j + 1, m, n, dp);
            } else if (j == n - 1) {
                  // last col --> only go down
                  return dp[i][j] = grid[i][j] + solve(grid, i + 1, j, m, n, dp);
            } else {
                  return dp[i][j] = grid[i][j]
                              + Math.min(solve(grid, i + 1, j, m, n, dp), solve(grid, i, j + 1, m, n, dp));
            }
      }

      public static int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int dp[][] = new int[m + 1][n + 1];
            for (int row[] : dp) {
                  Arrays.fill(row, -1);
            }
            return solve(grid, 0, 0, m, n, dp);
      }

      public static int minPathSum2(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int dp[][] = new int[m + 1][n + 1];

            dp[0][0] = grid[0][0];

            // Fill first row
            for (int col = 1; col < n; col++) {
                  dp[0][col] = grid[0][col] + dp[0][col - 1];
            }

            // Fill first col
            for (int row = 1; row < m; row++) {
                  dp[row][0] = grid[row][0] + dp[row - 1][0];
            }

            for (int i = 1; i < m; i++) {
                  for (int j = 1; j < n; j++) {
                        dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                  }
            }
            return dp[m - 1][n - 1];
      }

      public static void main(String[] args) {
            int grid[][] = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
            System.out.println(minPathSum(grid));
            System.out.println(minPathSum2(grid));
      }
}
