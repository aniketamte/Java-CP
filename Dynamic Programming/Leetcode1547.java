import java.util.*;

public class Leetcode1547 {
      static int[][] t;

      public static int solve(int[] cuts, int left, int right) {
            if (right - left == 1)
                  return 0;

            if (t[left][right] != -1)
                  return t[left][right];

            int result = Integer.MAX_VALUE;
            for (int index = left + 1; index <= right - 1; index++) {
                  int cost = solve(cuts, left, index) + solve(cuts, index, right) + (cuts[right] - cuts[left]);
                  result = Math.min(result, cost);
            }
            return t[left][right] = result;
      }

      public static int minCost(int n, int[] cuts) {
            int m = cuts.length;
            int[] newCuts = new int[m + 2];

            newCuts[0] = 0;
            System.arraycopy(cuts, 0, newCuts, 1, m);
            newCuts[m + 1] = n;

            Arrays.sort(newCuts);
            t = new int[m + 2][m + 2];
            for (int[] row : t) {
                  Arrays.fill(row, -1);
            }
            return solve(newCuts, 0, m + 1);
      }
      public static void main(String[] args) {
            int n = 7;
            int[] cuts = { 1, 3, 4, 5 };
            System.out.println("Minimum cost to cut the stick: " + minCost(n, cuts));
      }
}
