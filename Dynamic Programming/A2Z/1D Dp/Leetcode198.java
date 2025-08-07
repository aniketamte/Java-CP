public class Leetcode198 {
      public static int solve(int nums[], int i, int n){
            if(i >= n){
                  return 0;
            }
            int steal = nums[i] + solve(nums, i+2, n);
            int skip = solve(nums, i+1, n);
            return Math.max(steal, skip);
      }
      public static int rob(int[] nums){
            int n = nums.length;
            return solve(nums, 0, n);
      }
      public static void main(String[] args) {
            int nums[] = {1,2,3,1};
            System.out.println(rob(nums));
      }
}
