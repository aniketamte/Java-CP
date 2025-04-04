public class Leetcode121 {

  //Stock Buy and Sell
  //Striver SDE sheet
  //Time Complexity ----> O(n)

    public static int maxProfit(int[] prices) {
      int maxProfit = 0;
      int bestBuy = prices[0];
      for(int i=1; i<prices.length; i++){
            if(prices[i] > bestBuy){
                  maxProfit =Math. max(maxProfit, prices[i]-bestBuy);
            }
             bestBuy = Math.min(bestBuy, prices[i]);        
      }
      return maxProfit;
    }

    public static void main(String[] args) {
      int prices[] = {7,1,5,3,6,4};
      System.out.println(maxProfit(prices));
    }
}
