public class coinChange{
      public static int coinChanges(int coins[], int sum) {
            int n = coins.length;
          int dp[][] = new int[n + 1][sum + 1];
          //initialize - sum is 0
          //i -> coins; j->sum
      }
      public static void main(String[] args) {
        int coins[] = {1, 2, 3};
        int sum = 4;
        System.out.println(coinChanges(coins, sum));
    }
}