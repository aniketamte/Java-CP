public class Leetcode3021 {
      public static long flowerGame(int n, int m){
            return 1L * ((n+1)/2) * (m/2) + 1L * (n/2) * ((m+1)/2);
      }
      public static void main(String[] args) {
            int n = 3;
            int m = 2;
            System.out.println(flowerGame(n, m));
      }
}
