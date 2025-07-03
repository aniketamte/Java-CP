public class Leetcode3304 {
      public static char kthCharacter(int k){
            int shift = Integer.bitCount(k - 1);
            return (char) ('a' + shift);
      }

      public static char kthCharacter2(int k) {
            int idx = k - 1;
            StringBuilder result = new StringBuilder();
            result.append('a');

            while (result.length() < k) {
                  int n = result.length();
                  for (int i = 0; i < n; i++) {
                        char ch = result.charAt(i) == 'z' ? 'a' : (char) (result.charAt(i) + 1);
                        result.append(ch);
                  }
            }

            return result.charAt(idx);
      }

      public static void main(String[] args) {
            System.out.println(kthCharacter(5));
            System.out.println(kthCharacter2(5));
      }
}
