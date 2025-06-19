import java.util.*;

public class Leetcode31 {
      public static void nextPermutation(int[] nums) {
            int n = nums.length;
            int i = n - 1;
            while (i > 0 && nums[i] <= nums[i - 1]) {
                  i--;
            }

            if (i != 0) {
                  int index = i;

                  for (int j = n - 1; j >= i; j--) {
                        if (nums[j] > nums[i - 1]) {
                              index = j;
                              break;
                        }
                  }
                  swap(nums, i - 1, index);
            }
            reverse(nums, i, n - 1);
      }

      private static void swap(int[] nums, int a, int b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
      }

      private static void reverse(int[] nums, int start, int end) {
            while (start < end) {
                  swap(nums, start, end);
                  start++;
                  end--;
            }
      }

      public static void main(String[] args) {
            int nums[] = { 1, 2, 3 };
            Leetcode31 sol = new Leetcode31();

            System.out.println("Original array: " + Arrays.toString(nums));

            sol.nextPermutation(nums);

            System.out.println("Next permutation: " + Arrays.toString(nums));
      }
}
