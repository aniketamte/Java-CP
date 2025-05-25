import java.util.*;

public class Leetcode1823 {

      // Brute Force Approach
      public int findTheWinner(int n, int k) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                  arr.add(i);
            }

            int index = 0;
            while (arr.size() > 1) {
                  int idx = (index + k - 1) % arr.size();
                  arr.remove(idx);
                  index = idx;
            }
            return arr.get(0);
      }

      // Approach 3: Using Recursion
      // T.C : O(n)
      // S.C : O(1), but note that it will take o(n) system stack space
      private int findWinnerIdx(int n, int k) {
            if (n == 1) {
                  return 0; // index
            }

            int idx = findWinnerIdx(n - 1, k);
            idx = (idx + k) % n; // to find the original index in the original array

            return idx;
      }

      public int findTheWinner2(int n, int k) {
            int resultIdx = findWinnerIdx(n, k);
            return resultIdx + 1;
      }

      public static void main(String[] args) {
            Leetcode1823 solution = new Leetcode1823();

            int n = 5; // total number of players
            int k = 2; // count to eliminate

            int winner = solution.findTheWinner(n, k);
            System.out.println("The winner is: " + winner);
            int winner2 = solution.findTheWinner2(n, k);
            System.out.println("The winner is: " + winner2);
      }
}
