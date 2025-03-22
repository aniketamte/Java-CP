public class GFGPractice {
      //Revision
      //Unbounded Knapsack
      static int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n = val.length;
        int dp[][] = new int[n + 1][capacity + 1];

        //for 0th column
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        //for 0yj row
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        //Initialization
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < capacity + 1; j++) {
                if (wt[i - 1] <= j) {
                    //valid condition
                    dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);

                } else {
                    //invalid
                    dp[i][j] += dp[i - 1][j];
                }
            }
        }
        return dp[n][capacity];
    }
    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int capacity = 7;
        System.out.println(knapSack(val, wt, capacity));
    }
}
