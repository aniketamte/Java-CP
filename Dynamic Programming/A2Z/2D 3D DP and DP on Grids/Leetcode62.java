import java.util.Arrays;

public class Leetcode62{
      public static int solve(int i, int j, int m, int n, int dp[][]){
            if (i == m - 1 && j == n - 1) {
                  return 1; // found 1 path
            }

            if(i<0 || i>=m || j<0 || j>=n){
                  return 0; //Invalid path => no path found
            }

            if(dp[i][j] != -1){
                  return dp[i][j];
            }

            int right = solve(i, j+1, m, n, dp);
            int down = solve(i+1, j, m, n, dp);

            dp[i][j] = right + down;
            
            return dp[i][j];
      }

      public static int uniquePaths(int m, int n){
            int dp[][] = new int[m][n];
            for(int row[] : dp){
                  Arrays.fill(row, -1);
            }
            return solve(0, 0, m, n, dp);
      }

      public static int uniquePaths2(int m, int n){
             // Create a 2D array for storing the number of ways to reach each cell
            int[][] dp = new int[m][n];

            // Initialize the first row
            for (int col = 0; col < n; col++) {
                  dp[0][col] = 1; // Only one way to reach any cell in the first row
            }

            // Initialize the first column
            for (int row = 0; row < m; row++) {
                  dp[row][0] = 1; // Only one way to reach any cell in the first column
            }
            for (int i = 1; i < m; i++) {
                  for (int j = 1; j < n; j++) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                  }
            }

            // The bottom-right cell contains the total number of unique paths
            return dp[m - 1][n - 1];
      }

      public static void main(String[] args) {
            int m = 3, n = 7;
            System.out.println(uniquePaths(m, n));
            System.out.println(uniquePaths2(m, n));
      }
}