
import java.util.Arrays;

public class Leetcode70 {
    //Leetcode 70

    //Using Recursion
    //This solution shows TLE on Leetcode after submitting code
    public static int countWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        return countWays(n - 1) + countWays(n - 2);
    }

    //Memorization ---> O(n)
    public static int countWaysMemorization(int n, int ways[]) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (ways[n] != -1) {
            return ways[n];
        }
        ways[n] = countWaysMemorization(n - 1, ways) + countWaysMemorization(n - 2, ways);
        return ways[n];
    }

    //Tabulation Method
    public static int countWaysTab(int n) {
        int dp[] = new int[n + 1];    //We calculate from 0 to n+1

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                //0 write for negative values
                dp[i] = dp[i - 1] + 0;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int ways[] = new int[n + 1];
        Arrays.fill(ways, -1);
        System.out.println(countWays(n));
        System.out.println(countWaysMemorization(n, ways));
        System.out.println(countWaysTab(n));
    }
}
