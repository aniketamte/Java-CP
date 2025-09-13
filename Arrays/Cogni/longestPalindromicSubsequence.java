public class longestPalindromicSubsequence {
      public static int LPS(String s){
            return solve(s, 0, s.length()-1);
      }

      private static int solve(String s, int i, int j) {
            if(i>j){
                  return 0;
            }
            if(i == j){
                  return 1;
            }
            if(s.charAt(i) == s.charAt(j)){
                  return 2 + solve(s, i+1, j-1);
            } else{
                  return Math.max(solve(s, i+1, j), solve(s, i, j-1));
            }
      }
      public static void main(String[] args) {
            String s = "bbbab";
            System.out.println(LPS(s));
      }
}
