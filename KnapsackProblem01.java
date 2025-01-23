public class KnapsackProblem01 {
      public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;
        System.out.println(knapsanck(val, wt, W, val.length));
    }
}
