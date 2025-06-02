import java.util.*;

public class Leetcode131 {
      public static List<List<String>> partition(String s) {
            int n = s.length();
            List<List<String>> result = new ArrayList<>();
            List<String> curr = new ArrayList<>();
            backtrack(s, 0, curr, result);
            return result;
      }

      static void backtrack(String s, int idx, List<String> curr, List<List<String>> result) {
            if (idx == s.length()) {
                  result.add(new ArrayList<>(curr));
                  return;
            }
            for (int i = idx; i < s.length(); i++) {
                  if (isPalindrome(s, idx, i)) {
                        curr.add(s.substring(idx, i + 1));
                        backtrack(s, i + 1, curr, result);
                        curr.remove(curr.size() - 1);
                  }
            }
      }

      static boolean isPalindrome(String s, int l, int r) {
            while (l < r) {
                  if (s.charAt(l) != s.charAt(r))
                        return false;

                  l++;
                  r--;
            }
            return true;
      }

      public static void main(String[] args) {
            String s = "aab";
            List<List<String>> result = partition(s);
            System.out.println(result);
      }
}
