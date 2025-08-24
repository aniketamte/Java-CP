
public class Leetcode188 {

    public static int solve(int index, int operationNo, int k, int prices[], int dp[][]) {
        if (index == prices.length) {
            return 0;
        }

        if (operationNo == 2 * k) {
            return 0;
        }

        if (dp[index][operationNo] != -1) {
            return dp[index][operationNo];
        }

        int profit = 0;

        if (operationNo % 2 == 0) {
            int buy_karo = -prices[index] + solve(index + 1, operationNo + 1, k, prices, dp);
            int skip_karo = 0 + solve(index + 1, operationNo, k, prices, dp);
            profit = Math.max(buy_karo, skip_karo);
        } else {
            int sell_karo = prices[index] + solve(index + 1, operationNo + 1, k, prices, dp);
            int skip_karo = 0 + solve(index + 1, operationNo, k, prices, dp);
            profit = Math.max(sell_karo, skip_karo);
        }
        return dp[index][operationNo] = profit;
    }

    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2 * k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * k; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(0, 0, k, prices, dp);
    }

    //Bottom-Up Approach
    public static int maxProfit2(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }

        int dp[][] = new int[n + 1][2 * k + 1]; // +1 for base case row

        // Bottom-up filling
        for (int index = n - 1; index >= 0; index--) {
            for (int operationNo = 2 * k - 1; operationNo >= 0; operationNo--) {
                if (operationNo % 2 == 0) {
                    // Buy
                    int buy = -prices[index] + dp[index + 1][operationNo + 1];
                    int skip = dp[index + 1][operationNo];
                    dp[index][operationNo] = Math.max(buy, skip);
                } else {
                    // Sell
                    int sell = prices[index] + dp[index + 1][operationNo + 1];
                    int skip = dp[index + 1][operationNo];
                    dp[index][operationNo] = Math.max(sell, skip);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int prices[] = {2, 4, 1};
        int k = 2;
        System.out.println(maxProfit(k, prices));
        System.out.println(maxProfit2(k, prices));
    }
}
