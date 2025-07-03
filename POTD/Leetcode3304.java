public class Leetcode3304 {
      public static char kthCharacter(int k){
            int shift = Integer.bitCount(k - 1);
            return (char) ('a' + shift);
      }
      public static void main(String[] args) {
            System.out.println(kthCharacter(5));
      }
}
