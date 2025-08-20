public class Leetcode1277 {
      public static int countSquares(int[][] matrix){
            int m = matrix.length;
            int n = matrix[0].length;

            int dp[][] = new int[m][n];

            int ans = 0;

            for(int i=0; i<m; i++){ //column first
                  dp[i][0] = matrix[i][0];
                  ans += dp[i][0];
            }

            for(int j=1; j<n; j++){
                  //row first
                  dp[0][j] = matrix[0][j];
                  ans += dp[0][j];
            }

            //fill remaining dp array
            for(int i=1; i<m; i++){
                  for(int j=1; j<n; j++){
                        if(matrix[i][j] == 1){
                              dp[i][j] = 1 + Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]);
                        }
                        ans += dp[i][j];
                  }
            }
            return ans;
      }

      public static void main(String[] args) {
            int matrix[][] = {
                  {0, 1, 1, 1},
                  {1, 1, 1, 1},
                  {0, 1, 1, 1}
            };
            System.out.println(countSquares(matrix));
      }
}
