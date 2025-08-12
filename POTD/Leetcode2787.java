
import java.util.Arrays;

public class Leetcode2787 {

    static final int MOD = 1_000_000_007;
    static int[][] dp;

    public static int numberOfWays(int n, int x) {
        dp = new int[n + 1][n + 2]; // +2 so num can safely go beyond n
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(n, 1, x);
    }

    public static int solve(int n, int num, int x) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        int currVal = (int) Math.pow(num, x);
        if (currVal > n) {
            return 0;
        }

        if (dp[n][num] != -1) {
            return dp[n][num];
        }

        int take = solve(n - currVal, num + 1, x) % MOD;
        int skip = solve(n, num + 1, x) % MOD;

        dp[n][num] = (take + skip) % MOD;
        return dp[n][num];
    }

    public static void main(String[] args) {
        System.out.println(numberOfWays(10, 2)); // 1
        System.out.println(numberOfWays(4, 1));  // 2
        System.out.println(numberOfWays(160, 3)); // correct large test
    }
}
