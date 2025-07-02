import java.util.ArrayList;
import java.util.List;

public class Leetcode22 {
      private static List<String> result = new ArrayList<>();

      public static List<String> generateParenthesis(int n) {
            solve(n, "", 0, 0);
            return result;
      }

      private static void solve(int n, String curr, int open, int close) {
            if(curr.length() == 2 * n){
                  result.add(curr);
                  return;
            }
            if(open < n){
                  solve(n, curr + "(", open + 1, close);
            }
            if(close < open){
                  solve(n, curr + ")", open, close + 1);
            }
      }
      public static void main(String[] args) {
            System.out.println(generateParenthesis(3));
      }
}
