
public class Leetcode53 {

    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = nums[0];
        int start = 0;
        int end = 0;
        int tempStart = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > maxSum) {
                maxSum = sum;
                start = tempStart;
                end = i;
            }
            if (sum < 0) {
                sum = 0;
                tempStart = i + 1;
            }
        }
        // Print subarray with max sum
        System.out.print("Maximum Subarray: ");
        for (int i = start; i <= end; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        return maxSum;
    }

    public static void main(String[] args) {
        int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}
