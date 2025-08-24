public class Leetcode123 {
      public static int solve(int index, int buy, int prices[], int limit){
            int n = prices.length;
            if(index == n){
                  return 0;
            }
            if(limit == 0){
                  return 0;
            }
            int profit = 0;
            if(buy == 1){
                  int buy_karo = -prices[index] + solve(index+1, 0, prices, limit);
                  int skip_karo = 0 + solve(index+1, 1, prices, limit);
                  profit = Math.max(buy_karo, skip_karo);
            } else{
                  int sell_karo = prices[index] + solve(index, 1, prices, limit-1);
                  int skip_karo = 0 + solve(index + 1, 0, prices, limit);
                  profit = Math.max(sell_karo, skip_karo);
            }
            return profit;
      }

      public static int maxProfit(int[] prices){
            return solve(0, 1, prices, 2);
      }

      public static void main(String[] args) {
            int prices[] = {3,3,5,0,0,3,1,4};
            System.out.println(maxProfit(prices));
      }
}
