
public class Leetcode2970 {
    //Leetcode 2970 ----> Count the Number of Incremovable Subarrays I

    public static int incremovableSubarrayCount(int[] nums) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isIncreasingSubArray(nums, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isIncreasingSubArray(int nums[], int start, int end) {
        int n = nums.length;
        int prev = 0;
        for (int i = 0; i < n; i++) {
            if (i <= end && i >= start) {
                continue;
            }
            if (nums[i] <= prev) {
                return false;
            }
            prev = nums[i];
        }
        return true;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4};
        System.out.println(incremovableSubarrayCount(nums));
    }
}
