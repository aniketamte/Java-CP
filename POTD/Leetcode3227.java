public class Leetcode3227 {
      public static boolean doesAliceWin(String s){
            return s.chars().anyMatch(ch -> "aeiou".indexOf(ch) >= 0);
      }
      public static void main(String[] args) {
          String s = "leetcoder";
          System.out.println(doesAliceWin(s)); 
      }
}
