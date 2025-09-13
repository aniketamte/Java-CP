public class BuyAndSell {
      public static int maxProf(int prices[]){
            int n = prices.length;
            int dp[][] = new int[n][1];
            for(int i=0; i<n; i++){
                  dp[i][0] = -1;
            }
            return solve(0, prices, 0, dp);
      }
      public static int solve(int i, int prices[], int running, int dp[][]){
            if(i == prices.length){
                  return running;
            }
            if(dp[i][0] != -1){
                  return dp[i][0];
            }
            int nextRun = running + prices[i];
            int min = solve(i+1, prices, nextRun, dp);
            dp[i][0] = Math.min(min, nextRun);
            return dp[i][0];
      }
      public static void main(String[] args) {
            int prices[] = {-39957, -17136, 1, 2, -26711};
            System.out.println(maxProf(prices));
      }
}
