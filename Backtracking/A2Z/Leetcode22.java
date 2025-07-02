import java.util.ArrayList;
import java.util.List;

public class Leetcode22 {
      private static List<String> result = new ArrayList<>();

      public static List<String> generateParenthesis(int n) {
            solve(n, "", 0, 0);
            return result;
      }

      private static void solve(int n, String curr, int open, int close) {
            if (curr.length() == 2 * n) {
                  result.add(curr);
                  return;
            }

            if (open < n) {
                  curr += '(';
                  solve(n, curr, open + 1, close);
                  curr = curr.substring(0, curr.length() - 1);
            }
            if (close < open) {
                  curr += ')';
                  solve(n, curr, open, close + 1);
                  curr = curr.substring(0, curr.length() - 1);
            }
      }
      public static void main(String[] args) {
            System.out.println(generateParenthesis(3));
      }
}
