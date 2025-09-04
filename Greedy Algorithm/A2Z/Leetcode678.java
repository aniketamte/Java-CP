
public class Leetcode678 {

    public static boolean checkValidString(String s) {
        int n = s.length();
        Boolean[][] dp = new Boolean[n + 1][n + 1]; // memo table
        return solve(0, 0, s, n, dp);
    }

    private static boolean solve(int idx, int open, String s, int n, Boolean[][] dp) {
        if (idx == n) {
            return open == 0;
        }

        if (dp[idx][open] != null) {
            return dp[idx][open];
        }

        boolean isValid = false;

        char ch = s.charAt(idx);

        if (ch == '*') {
            // treat * as '('
            isValid |= solve(idx + 1, open + 1, s, n, dp);

            // treat * as empty
            isValid |= solve(idx + 1, open, s, n, dp);

            // treat * as ')'
            if (open > 0) {
                isValid |= solve(idx + 1, open - 1, s, n, dp);
            }
        } else if (ch == '(') {
            isValid |= solve(idx + 1, open + 1, s, n, dp);
        } else if (open > 0) { // ch == ')'
            isValid |= solve(idx + 1, open - 1, s, n, dp);
        }

        return dp[idx][open] = isValid;
    }

    public static boolean checkValidString2(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];

        dp[n][0] = true;

        for (int i = n - 1; i >= 0; i--) {
            for (int open = 0; open <= n; open++) {
                boolean isValid = false;
                char c = s.charAt(i);
                if (c == '*') {
                    if (open + 1 <= n) {
                        isValid |= dp[i + 1][open + 1];
                    }
                    isValid |= dp[i + 1][open];

                    if (open > 0) {
                        isValid |= dp[i + 1][open - 1];
                    }
                } else if (c == '(') {
                    if (open + 1 <= n) {
                        isValid |= dp[i + 1][open + 1];
                    }
                } else if (open > 0) {
                    isValid |= dp[i + 1][open - 1];
                }
                dp[i][open] = isValid;
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        String s = "(*))";
        System.out.println(checkValidString(s)); // true
        System.out.println(checkValidString2(s));
    }
}
