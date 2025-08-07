
import java.util.Arrays;

public class Leetcode63 {
      public static int solve(int i, int j, int obstacleGrid[][], int dp[][]) {
            if (i >= 0 && j >= 0 && obstacleGrid[i][j] == 1) {
                  return 0;
            }
            if (i == 0 && j == 0) {
                  return 1;
            }
            if (i < 0 || j < 0) {
                  return 0;
            }
            if (dp[i][j] != -1) {
                  return dp[i][j];
            }
            int up = solve(i - 1, j, obstacleGrid, dp);
            int left = solve(i, j - 1, obstacleGrid, dp);
            dp[i][j] = up + left;
            return dp[i][j];
      }

      public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int dp[][] = new int[m][n];
            for (int row[] : dp) {
                  Arrays.fill(row, -1);
            }
            return solve(m - 1, n - 1, obstacleGrid, dp);
      }

      public static void main(String[] args) {
            int obstacleGrid[][] = {
                        { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 }
            };
            System.out.println(uniquePathsWithObstacles(obstacleGrid));
      }
}
