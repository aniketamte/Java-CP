import java.util.Arrays;

public class Leetcode931 {
      static int n;
      public static int minFallingPathSum(int[][] matrix){
            n = matrix.length;
            int row = 0;
            int result = Integer.MAX_VALUE;
            int dp[][] = new int[n][n];

            for (int rows[] : dp) {
            Arrays.fill(rows, -1);
            }

            for(int col = 0; col < n; col++){
                  result = Math.min(result, solve(matrix, row, col, dp));
            }
            return result;
      }

      public static int solve(int matrix[][], int row, int col, int dp[][]){
            if(row == n-1){
                  return matrix[row][col];
            }
            int sum = matrix[row][col];
            int minSum = Integer.MAX_VALUE;

            if (dp[row][col] != -1) {
              return dp[row][col];
            }

            if(row + 1 < n && col-1 >= 0){
                  minSum = Math.min(minSum, sum + solve(matrix, row + 1, col - 1, dp));
            }

            if(row+1 < n){
                  minSum = Math.min(minSum, sum + solve(matrix, row + 1, col, dp));
            }
            
            if(row+1 <n && col+1 < n){
                  minSum = Math.min(minSum, sum + solve(matrix, row + 1, col + 1, dp));
            }

            return minSum;
      }

      public static void main(String[] args) {
            int matrix[][] = {
                  {2,1,3},
                  {6,5,4},
                  {7,8,9}
            };
            System.out.println(minFallingPathSum(matrix));
      }
}
