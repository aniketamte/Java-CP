public class Leetcode1394 {
      public static int findLucky(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n; i++) {
                  int val = arr[i] & 65535; // Lower 16 bits
                  if (val >= 1 && val <= n) {
                        arr[val - 1] += (1 << 16); // Increase high 16 bits
                  }
            }
            for (int val = n; val >= 1; val--) {
                  if ((arr[val - 1] >> 16) == val) {
                        return val;
                  }
            }
            return -1;
      }
      public static void main(String[] args) {
            int[] arr = {1, 2
                  , 2, 3, 3, 3, 4};
            System.out.println(findLucky(arr));
      }
}
