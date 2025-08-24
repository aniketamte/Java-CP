
public class Leetcode714 {

    // 1. Recursion + Memoization (Top-Down)
    public static int solve(int index, int buy, int[] prices, int fee, int[][] dp) {
        if (index == prices.length) {
            return 0;
        }

        if (dp[index][buy] != -1) {
            return dp[index][buy];
        }

        int profit;
        if (buy == 1) {
            // Two choices: Buy or Skip
            int buyKaro = -prices[index] + solve(index + 1, 0, prices, fee, dp);
            int skipKaro = solve(index + 1, 1, prices, fee, dp);
            profit = Math.max(buyKaro, skipKaro);
        } else {
            // Two choices: Sell (pay fee) or Skip
            int sellKaro = prices[index] - fee + solve(index + 1, 1, prices, fee, dp);
            int skipKaro = solve(index + 1, 0, prices, fee, dp);
            profit = Math.max(sellKaro, skipKaro);
        }

        return dp[index][buy] = profit;
    }

    public static int maxProfitMemo(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return solve(0, 1, prices, fee, dp); // start with buy = 1 (we are allowed to buy)
    }

    // 2. Bottom-Up (Tabulation)
    public static int maxProfitTabu(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2]; // dp[n][..] = 0 (base case)

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit;
                if (buy == 1) {
                    int buyKaro = -prices[index] + dp[index + 1][0];
                    int skipKaro = dp[index + 1][1];
                    profit = Math.max(buyKaro, skipKaro);
                } else {
                    int sellKaro = prices[index] - fee + dp[index + 1][1];
                    int skipKaro = dp[index + 1][0];
                    profit = Math.max(sellKaro, skipKaro);
                }
                dp[index][buy] = profit;
            }
        }
        return dp[0][1]; // start at day 0 with buy allowed
    }

    // 3. Main method wrapper (default to bottom-up)
    public static int maxProfit(int[] prices, int fee) {
        return maxProfitTabu(prices, fee);
        // OR: return maxProfitMemo(prices, fee); if you want memoization
    }

    public static void main(String[] args) {
        int prices[] = {1, 3, 2, 8, 4, 9};
        int fee = 2;

        System.out.println("Memoization: " + maxProfitMemo(prices, fee)); // 8
        System.out.println("Tabulation : " + maxProfitTabu(prices, fee)); // 8
        System.out.println("Final Call : " + maxProfit(prices, fee));     // 8
    }
}
