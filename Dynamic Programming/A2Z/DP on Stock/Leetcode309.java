
public class Leetcode309 {

    // Top-down (memoization)
    public static int solve(int index, int buy, int prices[], int dp[][]) {
        if (index >= prices.length) {
            return 0;
        }
        if (dp[index][buy] != -1) {
            return dp[index][buy];
        }

        int profit;
        if (buy == 1) {
            int buyKaro = -prices[index] + solve(index + 1, 0, prices, dp);
            int skipKaro = solve(index + 1, 1, prices, dp);
            profit = Math.max(buyKaro, skipKaro);
        } else {
            int sellKaro = prices[index] + solve(index + 2, 1, prices, dp); // cooldown
            int skipKaro = solve(index + 1, 0, prices, dp);
            profit = Math.max(sellKaro, skipKaro);
        }

        return dp[index][buy] = profit;
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return solve(0, 1, prices, dp);
    }

    // Bottom-up (tabulation)
    public static int maxProfit2(int prices[]) {
        int n = prices.length;
        int dp[][] = new int[n + 2][2]; // +2 because of index+2 access

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit;
                if (buy == 1) {
                    int buyKaro = -prices[index] + dp[index + 1][0];
                    int skipKaro = dp[index + 1][1];
                    profit = Math.max(buyKaro, skipKaro);
                } else {
                    int sellKaro = prices[index] + dp[index + 2][1];
                    int skipKaro = dp[index + 1][0];
                    profit = Math.max(sellKaro, skipKaro);
                }
                dp[index][buy] = profit;
            }
        }
        return dp[0][1];
    }

    public static void main(String[] args) {
        int prices[] = {1, 2, 3, 0, 2};
        System.out.println("Top-Down: " + maxProfit(prices));   // ✅ 3
        System.out.println("Bottom-Up: " + maxProfit2(prices)); // ✅ 3
    }
}
