public class MatrixChainMultiplication{

      //Matrix chain Multiplication ===> GFG Practice Question
      //Solve this question using dynamic programming
      //22-03-2025

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
      
      public static void main(String[] args) {
            int arr[] = {1,2,3,4,3};  //n=5
            int n = arr.length;

            System.out.println(MCM(arr, 1, n-1));
      }
}