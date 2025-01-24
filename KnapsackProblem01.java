
public class KnapsackProblem01 {

    //This is Recursion code
    public static int knapsanck(int val[], int wt[], int W, int n) {
        //W = Capacity of Bag  
        if (W == 0 || n == 0) {
            return 0;
        }
        if (wt[n - 1] <= W) {  //Valid condition
            //include

            int ans1 = val[n - 1] + knapsanck(val, wt, W - wt[n - 1], n - 1);

            //exlude
            int ans2 = knapsanck(val, wt, W, n - 1);
            return Math.max(ans1, ans2);
        } else {
            //Not valid Condition
            return knapsanck(val, wt, W, n - 1);
        }
    }

    //Memorization Code
    public static int knapsanckMemorization(int val[], int wt[], int W, int n, int dp[][]) {
        //W = Capacity of Bag  
        if (W == 0 || n == 0) {
            return 0;
        }
        if (dp[n][W] != -1) {
            return dp[n][W];
        }
        if (wt[n - 1] <= W) {  //Valid condition
            //include

            int ans1 = val[n - 1] + knapsanckMemorization(val, wt, W - wt[n - 1], n - 1, dp);

            //exlude
            int ans2 = knapsanckMemorization(val, wt, W, n - 1, dp);
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        } else {
            //Not valid Condition
            dp[n][W] = knapsanckMemorization(val, wt, W, n - 1, dp);
            return dp[n][W];
        }
    }

    //Tabular Method Code for 0-1 Knapsack
     public static int knapsackTab(int val[], int wt[], int W){
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
         for (int i = 1; i < n + 1; i++) {
             for (int j = 1; j < W + 1; j++) {
                 int v = val[i - 1]; //ith item val
                 int w = wt[i - 1];  //ith item wait
                 if (w <= j) {
                     //for valid condition
                     int incProfit = v + dp[i - 1][j - w];
                     int excProfit = dp[i - 1][j];
                     dp[i][j] = Math.max(incProfit, excProfit);
                 } else {
                     //invalid condition
                     int excProfit = dp[i - 1][j];
                     dp[i][j] = excProfit;
                 }
             }
         }
         print(dp);
         return dp[n][W];
     }
     public static void print(int dp[][]){
        
     }

    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;
        int dp[][] = new int[val.length + 1][W + 1];

        //Initialization
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsanck(val, wt, W, val.length));
        System.out.println(knapsanckMemorization(val, wt, W, val.length, dp));
    }
}
