
import java.util.Arrays;

public class Leetcode198 {
      //Recursive Approach
      public static int rob(int[] nums){
            int n = nums.length;
            int dp[] = new int[n+1];
            Arrays.fill(dp, -1);
            return solve(nums, 0, dp);
      }
      public static int solve(int nums[], int i, int dp[]){
            if(i >= nums.length){
                  return 0;
            }

            if(dp[i] != -1){
                  return dp[i];
            }

            int steal = nums[i] + solve(nums, i+2, dp);
            int skip = solve(nums, i+1, dp);

            dp[i] = Math.max(steal, skip);
            return dp[i];
      }
      public static void main(String[] args) {
            int nums[] = {1,2,3,1};
            System.out.println(rob(nums));
      }
}
