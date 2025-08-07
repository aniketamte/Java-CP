
import java.util.Arrays;

public class Leetcode64 {
      public static int solve(int grid[][], int i, int j, int m, int n, int dp[][]) {
            if (i == m - 1 && j == n - 1) {
                  return grid[i][j];
            }

            if(dp[i][j] != -1){
                  return dp[i][j];
            }

            if (i == m - 1) {
                  // last row --> only go right
                  return dp[i][j] = grid[i][j] + solve(grid, i, j + 1, m, n, dp);
            } else if (j == n - 1) {
                  // last col --> only go down
                  return dp[i][j] = grid[i][j] + solve(grid, i + 1, j, m, n, dp);
            } else {
                  return dp[i][j] = grid[i][j] + Math.min(solve(grid, i + 1, j, m, n, dp), solve(grid, i, j + 1, m, n, dp));
            }
      }

      public static int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int dp[][] = new int[m+1][n+1];
            for(int row[] : dp){
                  Arrays.fill(row, -1);
            }
            return solve(grid, 0, 0, m, n, dp);
      }

      public static void main(String[] args) {
            int grid[][] = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
            System.out.println(minPathSum(grid));
      }
}
