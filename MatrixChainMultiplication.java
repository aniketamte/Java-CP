import java.util.Arrays;

public class MatrixChainMultiplication{

      //Matrix chain Multiplication ===> GFG Practice Question
      //Solve this question using dynamic programming
      //22-03-2025

      //solve using Recursion Method
      public static int MCM(int arr[], int i, int j){
            //i ===> Strating Point
            //j ===> Ending Point

            if(i==j){
                  return 0;  //single matrix case
            }

            int ans = Integer.MAX_VALUE;

            for(int k=i; k<=j-1; k++){
                  int cost1 = MCM(arr, i, k);  //arr[i-1] * arr[k]
                  int cost2 = MCM(arr, k+1, j);  //arr[k] * arr[j]
                  int cost3 = arr[i-1] * arr[k] * arr[j];
                  int finalCost = cost1 + cost2 + cost3;
                  ans = Math.min(ans, finalCost);
            }
            return ans;
      }

      //Solve using Memoization Method

      public static int MCM2(int arr[], int i, int j, int dp[][]) {
        //i ===> Strating Point
        //j ===> Ending Point

        if (i == j) {
            return 0;  //single matrix case
        }

        if(dp[i][j] != -1){  //answer is already calculated
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {
            int cost1 = MCM2(arr, i, k, dp);  //arr[i-1] * arr[k]
            int cost2 = MCM2(arr, k + 1, j, dp);  //arr[k] * arr[j]
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }
        return dp[i][j] = ans;
    }

      
      public static void main(String[] args) {
            int arr[] = {1,2,3,4,3};  //n=5
            int n = arr.length;

            int dp[][] = new int[n][n];

            for(int i=0; i<n; i++){   //fill all index in table as -1
                  Arrays.fill(dp[i], -1);
            }

            System.out.println("Solve using Recursion Method : " + MCM(arr, 1, n-1));

            System.out.println("Solve using Memoization Method : " + MCM2(arr, 1, n-1, dp));
      }
}