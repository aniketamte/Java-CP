
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

      public static void main(String[] args) {
            int m = 3, n = 7;
            System.out.println(uniquePaths(m, n));
      }
}