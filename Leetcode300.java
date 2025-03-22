
import java.util.*;

public class Leetcode300 {
    //Longest Increasinng Subsequence

    public static int LCS(int nums[], int nums2[]) {
        int n = nums.length;
        int m = nums2.length;
        int dp[][] = new int[n + 1][m + 1];

        //Initialize ---> Optional(Not Required)
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = 0;
        }

        //Bottom Up
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                //same last one
                if (nums[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //different last one
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }

    public static int lengthOfLIS(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        //Sorted unique element
        int nums2[] = new int[set.size()];
        int i = 0;
        for (int num : set) {
            nums2[i] = num;
            i++;
        }

        //Sort array in Ascending order
        Arrays.sort(nums2);
        return LCS(nums, nums2);
    }

    public static void print(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = {50, 3, 10, 7, 40, 80};
        System.out.println(lengthOfLIS(nums));
    }
}
