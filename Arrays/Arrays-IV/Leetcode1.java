
import java.util.HashMap;

public class Leetcode1 {
      public static int[] twoSums(int nums[], int target) {
            int n = nums.length;
            HashMap<Integer, Integer> mp = new HashMap<>();

            for (int i = 0; i < n; i++) {
                  int remaining = target - nums[i];
                  if (mp.containsKey(remaining)) {
                        return new int[] { mp.get(remaining), i };
                  }
                  mp.put(nums[i], i);
            }
            return new int[] { -1, -1 };
      }

      public static void main(String[] args) {
            int[] nums = { 2, 7, 11, 15 };
            int target = 18;
            int[] result = twoSums(nums, target);
            System.out.println("The indices of the two numbers are: " + result[0] + " " + result[1]);
      }
}
