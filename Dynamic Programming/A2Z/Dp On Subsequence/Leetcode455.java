import java.util.*;

public class Leetcode455 {
      public static int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);

            int m = g.length;
            int n = s.length;

            int i = 0;
            int j = 0;

            while (i < m && j < n) {
                  if (g[i] <= s[j]) {
                        i++;
                  }
                  j++;
            }
            return i;
      }

      //Dont solve using dp best approach is using greedy algorithm which Solve above
      
      public static int findContentChildrenDP(int[] g, int[] s) {
            int m = g.length;
            int n = s.length;
            int[][] dp = new int[m + 1][n + 1];

            Arrays.sort(g);
            Arrays.sort(s);

            for (int i = 1; i <= m; i++) {
                  for (int j = 1; j <= n; j++) {
                        if (s[j - 1] >= g[i - 1]) {
                              dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i][j - 1]);
                        } else {
                              dp[i][j] = dp[i][j - 1];
                        }
                  }
            }

            return dp[m][n];
      }

      public static void main(String[] args) {
            int[] g = { 1, 2 };
            int[] s = { 1, 2, 3 };
            System.out.println(findContentChildren(g, s));
            System.out.println(findContentChildrenDP(g, s));
      }
}
