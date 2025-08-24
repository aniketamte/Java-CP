public class Leetcode122 {
    public static int solve(int index, int buy, int prices[], int dp[][]) {
        if (index == prices.length) {
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
            int sellKaro = prices[index] + solve(index + 1, 1, prices, dp);
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

    //Bottom - up Approach

    public static int maxProfit2(int prices[]){
        int n = prices.length;
        int dp[][] = new int[n+1][2];

        for(int index=n-1; index>=0; index--){
            for(int buy=0; buy<=1; buy++){
                  int profit = 0;

                if (buy == 1) {
                    int buyKaro = -prices[index] + dp[index+1][0];
                    int skipKaro = 0 + dp[index + 1][1];
                    profit = Math.max(buyKaro, skipKaro);
                } else {
                    int sellKaro = prices[index] + dp[index + 1][1];
                    int skipKaro = 0 + dp[index + 1][0];
                    profit = Math.max(sellKaro, skipKaro);
                }

                // ✅ store in dp before returning
                dp[index][buy] = profit;
            }
        }
        return dp[0][1];
    }

    public static void main(String[] args) {
        int prices[] = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
