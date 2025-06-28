import java.util.Arrays;

public class Leetcode2099 {
      public static int[] maxSubsequence(int[] nums, int k) {
            int[][] valueWithIndex = new int[nums.length][2];
            for (int i = 0; i < nums.length; i++) {
                  valueWithIndex[i] = new int[] { nums[i], i };
            }

            Arrays.sort(valueWithIndex, (a, b) -> b[0] - a[0]);
            Arrays.sort(valueWithIndex, 0, k, (a, b) -> a[1] - b[1]);
            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                  result[i] = valueWithIndex[i][0];
            }

            return result;
      }

      public static void main(String[] args) {
            int[] nums = { 2, 1, 3, 3, 4, 5 };
            int k = 2;
            int[] result = maxSubsequence(nums, k);
            System.out.println(Arrays.toString(result));
      }
}
