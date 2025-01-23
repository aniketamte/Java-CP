public class KnapsackProblem01 {
      public static int knapsanck(int val[], int wt[], int W, int n){
            //W = Capacity of Bag  
          if (W == 0 || n == 0) {
              return 0;
          }
      }
      public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;
        System.out.println(knapsanck(val, wt, W, val.length));
    }
}
