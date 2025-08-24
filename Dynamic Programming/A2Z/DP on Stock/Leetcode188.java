public class Leetcode188 {
    public static int solve(int index, int operationNo, int k, int prices[]) {
        if (index == prices.length) {
            return 0;
        }

        if (operationNo == 2 * k) {
            return 0;
        }

        int profit = 0;

        if (operationNo % 2 == 0) {
            int buy_karo = -prices[index] + solve(index + 1, operationNo + 1, k, prices);
            int skip_karo = 0 + solve(index + 1, operationNo, k, prices);
            profit = Math.max(buy_karo, skip_karo);
        } else {
            int sell_karo = prices[index] + solve(index + 1, operationNo + 1, k, prices);
            int skip_karo = 0 + solve(index + 1, operationNo, k, prices);
            profit = Math.max(sell_karo, skip_karo);
        }
        return profit;
    }

    public static int maxProfit(int k, int[] prices) {
        return solve(0, 0, k, prices);
    }

    public static void main(String[] args) {
      int prices[] = {2, 4, 1};
      int k = 2;
      System.out.println(maxProfit(k, prices));
    }
}
