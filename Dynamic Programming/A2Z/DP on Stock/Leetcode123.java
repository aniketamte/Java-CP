import java.util.*;
public class Leetcode123 {

    public static int solve(int index, int buy, int prices[], int limit, int dp[][][]) {
        int n = prices.length;
        if (index == n) {
            return 0;
        }
        if (limit == 0) {
            return 0;
        }
        if(dp[index][buy][limit] != -1){
            return dp[index][buy][limit];
        }
        int profit = 0;
        if (buy == 1) {
            int buy_karo = -prices[index] + solve(index + 1, 0, prices, limit, dp);
            int skip_karo = 0 + solve(index + 1, 1, prices, limit, dp);
            profit = Math.max(buy_karo, skip_karo);
        } else {
            int sell_karo = prices[index] + solve(index, 1, prices, limit - 1, dp);
            int skip_karo = 0 + solve(index + 1, 0, prices, limit, dp);
            profit = Math.max(sell_karo, skip_karo);
        }
        return dp[index][buy][limit] = profit;
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n][2][3];
        // fill with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(0, 1, prices, 2, dp);
    }

    public static void main(String[] args) {
        int prices[] = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(prices));
    }
}
