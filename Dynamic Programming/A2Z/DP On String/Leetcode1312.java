import java.util.Arrays;
public class Leetcode1312 {
      public static int solve(String s, int i, int j, int dp[][]){
            if(i >= j){
                  return 0;
            }

            if(dp[i][j] != -1){
                  return dp[i][j];
            }

            if(s.charAt(i) == s.charAt(j)){
                  return solve(s, i+1, j-1, dp);
            } else{
                  return 1 + Math.min(solve(s, i+1, j, dp), solve(s, i, j-1, dp));
            }
      }

      public static int minInsertions(String s){
            int n = s.length();
            int dp[][] = new int[n][n];
            for(int row[] : dp){
                  Arrays.fill(row, -1);
            }
            return solve(s, 0, n-1, dp);
      }

      public static int minInsertions2(String s){
            int n = s.length();
            int dp[][] = new int[n][n];

            for (int L = 2; L <= n; L++) {
              for (int i = 0; i < n - L + 1; i++) {
                  int j = i + L - 1;
                  if (s.charAt(i) == s.charAt(j)) {
                      dp[i][j] = dp[i + 1][j - 1];
                  } else {
                      dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);
                  }
              }
          }

          return dp[0][n - 1];
      }

      public static void main(String[] args) {
            String s = "leetcode";
            System.out.println(minInsertions(s));
            System.out.println(minInsertions(s));
      }
}
