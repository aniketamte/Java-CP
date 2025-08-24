public class Leetcode121{
      public static int maxProfit(int[] prices){
            int maxProfit = 0;
            int bestBuy = prices[0];
            int n = prices.length;

            for(int i=1; i<n; i++){
                  if(prices[i] > bestBuy){
                        maxProfit = Math.max(maxProfit, prices[i] - bestBuy);
                  }
                  bestBuy = Math.min(bestBuy, prices[i]);
            }
            return maxProfit;
      }

      public static void main(String[] args) {
            int prices[] = {7, 1, 5, 3, 6, 4};
            System.out.println(maxProfit(prices));
      }
}