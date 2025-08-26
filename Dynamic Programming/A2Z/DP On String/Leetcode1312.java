public class Leetcode1312 {
      public static int solve(String s, int i, int j){
            if(i >= j){
                  return 0;
            }
            if(s.charAt(i) == s.charAt(j)){
                  return solve(s, i+1, j-1);
            } else{
                  return 1 + Math.min(solve(s, i+1, j), solve(s, i, j-1));
            }
      }

      public static int minInsertions(String s){
            int n = s.length();
            return solve(s, 0, n-1);
      }

      public static void main(String[] args) {
            String s = "leetcode";
            System.out.println(minInsertions(s));
      }
}
