
public class Leetcode1143 {

    public static int longestCommonSubsequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(str1, str2, n, m, dp);
    }

    public static int solve(String str1, String str2, int n, int m, int dp[][]) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        //same
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return solve(str1, str2, n - 1, m - 1, dp) + 1;
        } else {
            //diff
            int ans1 = solve(str1, str2, n - 1, m, dp);
            int ans2 = solve(str1, str2, n, m - 1, dp);
            dp[n][m] = Math.max(ans1, ans2);
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "abcdge";
        String str2 = "abedg";
        //ans 4 yeil bcz lcs is abdg
        System.out.println(longestCommonSubsequence(str1, str2));
    }
}
