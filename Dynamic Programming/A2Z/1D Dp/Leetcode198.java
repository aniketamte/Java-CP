
import java.util.Arrays;

public class Leetcode198 {
      public static int solve(int nums[], int i, int dp[]) {
            if (i >= nums.length) {
                  return 0;
            }

            if (dp[i] != -1) {
                  return dp[i];
            }

            int add = nums[i] + solve(nums, i + 2, dp);
            int skip = solve(nums, i + 1, dp);

            dp[i] = Math.max(add, skip);
            return dp[i];
      }

      public static int rob(int[] nums) {
            int n = nums.length;
            int dp[] = new int[n];
            Arrays.fill(dp, -1);
            return solve(nums, 0, dp);
      }

      public static int rob2(int nums[]) {
            int n = nums.length;
            if(n==1){
                  return nums[0];
            }
            int dp[] = new int[n + 1];
            dp[0] = 0;
            dp[1] = nums[0];

            for (int i = 2; i <= n; i++) {
                  int add = nums[i - 1] + dp[i - 2];
                  int skip = dp[i - 1];

                  dp[i] = Math.max(add, skip);
            }
            return dp[n];
      }

      public static void main(String[] args) {
            int nums[] = { 1, 2, 3, 1 };
            System.out.println(rob(nums));
            System.out.println(rob2(nums));
      }
}
