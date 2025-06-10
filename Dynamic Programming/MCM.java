import java.util.Arrays;

public class MCM {
      public static int mcm(int arr[], int i, int j){
            if(i==j){
                  return 0;
            }
            int minCost = Integer.MAX_VALUE;
            for(int k=i; k<=j-1; k++){
                  int cost1 = mcm(arr, i, k); //Ai......Ak  => arr[i-1] * arr[k]
                  int cost2 = mcm(arr, k+1, j); //Ai+1.....Aj   => arr[k] * arr[j]
                  int cost3 = arr[i-1] * arr[k] * arr[j];
                  int finalCost = cost1 + cost2 + cost3;
                  minCost = Math.min(minCost, finalCost);
            }
            return minCost;  
      }
      
      //Using Memoization

      public static int mcm2(int arr[], int i, int j, int dp[][]) {
            if (i == j) {
                  return 0;
            }
            if(dp[i][j] != -1){
                  return dp[i][j];
            }
            int minCost = Integer.MAX_VALUE;
            for (int k = i; k <= j - 1; k++) {
                  int cost1 = mcm2(arr, i, k, dp); // Ai......Ak => arr[i-1] * arr[k]
                  int cost2 = mcm2(arr, k + 1, j, dp); // Ai+1.....Aj => arr[k] * arr[j]
                  int cost3 = arr[i - 1] * arr[k] * arr[j];
                  int finalCost = cost1 + cost2 + cost3;
                  minCost = Math.min(minCost, finalCost);
            }
            return dp[i][j] = minCost;
      }
      public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 3};
            int n = arr.length;
            System.out.println("Minimum Cost is : " + mcm(arr, 1, n-1));
            int dp[][] = new int[n][n];
            for(int i=0; i<n; i++){
                  Arrays.fill(dp[i], -1);
            }
            System.out.println("Minimum Cost is : " + mcm2(arr, 1, n-1, dp));
      }
}
