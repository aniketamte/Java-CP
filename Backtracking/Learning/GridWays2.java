public class GridWays2 {
      public static int gridWays2(int i, int j, int n, int m, int dp[][]){
            if(i==n-1 && j==m-1){
                  return 1;
            }
            if(i>=n || j>=m){
                  return 0;
            }
            if(dp[i][j] != -1){
                  return dp[i][j];
            }
            dp[i][j] = gridWays2(i+1, j, n, m, dp) + gridWays2(i, j+1, n, m, dp);
            return dp[i][j];
      }
      public static void main(String[] args) {
            int n = 3;
            int m = 3;
            int dp[][] = new int[n][m];

            for(int i=0; i<n; i++){
                  for(int j=0; j<m; j++){
                        dp[i][j] = -1;
                  }
            }
            System.out.println(gridWays2(0, 0, n, m, dp));
      }
}
