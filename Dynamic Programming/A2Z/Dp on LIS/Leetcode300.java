import java.util.*;
public class Leetcode300{
      public static int lcs(int nums[], int nums2[]){
            int m = nums.length;
            int n = nums2.length;
            int dp[][] = new int[m+1][n+1];

            //Initialize
            for(int i=0; i<n+1; i++){
                  dp[0][i] = 0;
            }
            for(int j=0; j<m; j++){
                  dp[j][0] = 0;
            }

            //Bottom-up
            for(int i=1; i<m+1; i++){
                  for(int j=1; j<n+1; j++){
                        if(nums[i-1] == nums2[j-1]){
                              dp[i][j] = dp[i-1][j-1] + 1;
                        } else{
                              int ans1 = dp[i-1][j];
                              int ans2 = dp[i][j-1];
                              dp[i][j] = Math.max(ans1, ans2);
                        }
                  }
            }

            for(int i=0; i<=m; i++){
                  for(int j=0; j<=n; j++){
                        System.out.print(dp[i][j] + " ");
                  }
                  System.out.println();
            }
            return dp[m][n];
      }
      public static int lengthOfLIS(int[] nums){
            HashSet<Integer> set = new HashSet<>();
            for(int i=0; i<nums.length; i++){
                  set.add(nums[i]);
            }

            int nums2[] = new int[set.size()];
            int i=0;
            for(int num : set){
                  nums2[i] = num;
                  i++;
            }

            Arrays.sort(nums2);
            return lcs(nums, nums2);
      }
      public static void main(String[] args) {
            int nums[] = {10, 9, 2, 5, 3, 7, 101, 18};
            System.out.println(lengthOfLIS(nums));
      }
}