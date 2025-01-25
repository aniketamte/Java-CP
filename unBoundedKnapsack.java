public class unBoundedKnapsack {
      public static int unboundedKnap(int val[], int wt[], int W){
            int n = val.length;
          int dp[][] = new int[n + 1][W + 1];

          for (int i = 0; i < dp.length; i++) {
              //for 0th column
              dp[i][0] = 0;
          }
          for (int j = 0; j < dp[0].length; j++) {
              //for 0th row
              dp[0][j] = 0;
          }
      }
      public static void print(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
      public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;
        System.out.println(unboundedKnap(val, wt, W));
    }
}
