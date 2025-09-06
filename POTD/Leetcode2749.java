public class Leetcode2749 {
      public static int makeTheIntegerZero(int num1, int num2){
            for (int k = 1; k <= 60; k++) {
              long x = 1L * num1 - 1L * num2 * k;
              if (x < k) {
                  return -1;
              }
              if (k >= Long.bitCount(x)) {
                  return k;
              }
          }
          return -1;
      }

      public static void main(String[] args) {
            int num1 = 3, num2 = -2; //3
            System.out.println(makeTheIntegerZero(num1, num2));
      }
}
