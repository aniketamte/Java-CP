
public class LCS2 {
    //Longest common Substring ---> O(n*m)

    public static int longestCommonSubstring(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        //create 2D Array
        int dp[][] = new int[n + 1][m + 1];

        int ans = 0;

        //Initialization for 0th row and 0th column
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        //Bottom Up

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    //Same
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    //Different
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "ABCDE";
        String s2 = "ABGCE";
        System.out.println("Longest Common Substring : " + longestCommonSubstring(s1, s2));
    }
}
