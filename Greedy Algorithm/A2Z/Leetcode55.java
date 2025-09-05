public class Leetcode55 {
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        Boolean dp[] = new Boolean[n];
        return solve(nums, n, 0, dp);
    }

    private static boolean solve(int[] nums, int n, int idx, Boolean dp[]) {
        if (idx == n - 1) {
            return true;
        }
        if (dp[idx] != null) {
            return dp[idx]; 
        }
        for (int i = 1; i <= nums[idx]; i++) {
            if (idx + i < n && solve(nums, n, idx + i, dp)) {
                return true;
            }
        }
        return dp[idx] = false;
    }

    public static boolean canJump2(int[] nums) {
        int n = nums.length;
        Boolean dp[] = new Boolean[n];
        dp[0] = true;
        for(int i=1; i<n; i++){
            for(int j=i-1; j>=0; j--){
                if(dp[j] == true && j+nums[j]>= i){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int nums[] = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
        System.out.println(canJump2(nums));
    }
}
