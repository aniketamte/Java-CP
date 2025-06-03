
import java.util.Arrays;

public class Leetcode213 {
      // Recursive Approach
      public static int rob(int[] nums) {
            int n = nums.length;
            if (n == 1)
                  return nums[0]; 

            // Case 1: exclude last house
            int[] dp1 = new int[n];
            Arrays.fill(dp1, -1);
            int max1 = solve(nums, 0, n - 2, dp1);

            // Case 2: exclude first house
            int[] dp2 = new int[n];
            Arrays.fill(dp2, -1);
            int max2 = solve(nums, 1, n - 1, dp2);

            return Math.max(max1, max2);
      }

      public static int solve(int[] nums, int start, int end, int[] dp) {
            if (start > end)
                  return 0;

            if (dp[start] != -1)
                  return dp[start];

            int steal = nums[start] + solve(nums, start + 2, end, dp);
            int skip = solve(nums, start + 1, end, dp);

            return dp[start] = Math.max(steal, skip);
      }

      public static void main(String[] args) {
            int nums[] = { 1, 2, 3, 1 };
            System.out.println(rob(nums));
      }
}
