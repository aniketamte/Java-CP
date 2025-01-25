public class TargetSum {
      //Time Complexity ---> O(n * sum)

    public static boolean targetSumSubset(int arr[], int sum){

    }
    
      public static void print(boolean dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
      public static void main(String[] args) {
        int arr[] = {4, 2, 7, 1, 3};
        int sum = 10;
        System.out.println(targetSumSubset(arr, sum));
    }
}