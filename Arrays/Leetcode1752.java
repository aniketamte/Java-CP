
public class Leetcode1752 {
      public static boolean check(int[] nums) {
            int spike = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                  if (nums[i] > nums[i + 1]) {
                        spike++;
                  }
            }
            if (nums[nums.length - 1] > nums[0]) {
                  spike++;
            }
            if (spike > 1) {
                  return false;
            }
            return true;
      }

      public static void main(String[] args) {
            int nums[] = { 3, 4, 5, 1, 9 };
            System.out.println(check(nums));
      }
}
