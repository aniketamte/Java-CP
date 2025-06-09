public class Leetcode931 {
      public static int minFallingPathSum(int[][] matrix) {
            int n = matrix.length;
            int[][] dp = new int[n][n];
            // Fill dp with a default value (e.g., Integer.MAX_VALUE)
            for (int i = 0; i < n; i++) {
                  for (int j = 0; j < n; j++) {
                        dp[i][j] = Integer.MAX_VALUE;
                  }
            }

            int min = Integer.MAX_VALUE;
            for (int col = 0; col < n; col++) {
                  min = Math.min(min, solve(matrix, 0, col, dp));
            }
            return min;
      }

      public static int solve(int[][] matrix, int row, int col, int[][] dp) {
            int n = matrix.length;

            // Check for out of bounds
            if (col < 0 || col >= n)
                  return Integer.MAX_VALUE;

            // Base case
            if (row == n - 1)
                  return matrix[row][col];

            // Memoization check
            if (dp[row][col] != Integer.MAX_VALUE)
                  return dp[row][col];

            int downLeft = solve(matrix, row + 1, col - 1, dp);
            int down = solve(matrix, row + 1, col, dp);
            int downRight = solve(matrix, row + 1, col + 1, dp);

            dp[row][col] = matrix[row][col] + Math.min(down, Math.min(downLeft, downRight));
            return dp[row][col];
      }

      public static void main(String[] args) {
            int[][] matrix = {
                        { 2, 1, 3 },
                        { 6, 5, 4 },
                        { 7, 8, 9 }
            };
            System.out.println(minFallingPathSum(matrix)); // Output: 13
      }
}
  