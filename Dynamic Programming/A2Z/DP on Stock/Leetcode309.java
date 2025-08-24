public class Leetcode309 {
    public static int solve(int index, int buy, int prices[], int dp[][]) {
        if (index >= prices.length) {
            return 0;
        }

        // ✅ check if already solved
        if (dp[index][buy] != -1) {
            return dp[index][buy];
        }

        int profit = 0;

        if (buy == 1) {
            int buyKaro = -prices[index] + solve(index + 1, 0, prices, dp);
            int skipKaro = 0 + solve(index + 1, 1, prices, dp);
            profit = Math.max(buyKaro, skipKaro);
        } else {
            int sellKaro = prices[index] + solve(index + 2, 1, prices, dp);
            int skipKaro = 0 + solve(index + 1, 0, prices, dp);
            profit = Math.max(sellKaro, skipKaro);
        }

        // ✅ store in dp before returning
        dp[index][buy] = profit;
        return profit;
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];

        // initialize dp with -1 (uncomputed states)
        for (int i = 0; i < n; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return solve(0, 1, prices, dp); // start with buy allowed
    }

    public static void main(String[] args) {
        int prices[] = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
    }
}
