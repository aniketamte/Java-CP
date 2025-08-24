public class Leetcode121{
      public static int maxProfit2(int prices[]){
            int minimum = prices[0];
            int maxProfit = 0;
            int n = prices.length;

            for(int i=0; i<n; i++){
                  int cost = prices[i] - minimum;
                  maxProfit = Math.max(maxProfit, cost);
                  minimum = Math.min(minimum, prices[i]);
            }
            return maxProfit;
      }
      public static void main(String[] args) {
            int prices[] = {7, 1, 5, 3, 6, 4};
            System.out.println(maxProfit2(prices));
      }
}