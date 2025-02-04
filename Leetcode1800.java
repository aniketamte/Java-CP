
public class Leetcode1800 {

    public static int maxAscendingSum(int[] nums) {
        int maxSum = 0;
        //Outer loop to start from each element in array

        for (int start = 0; start < nums.length; start++) {
            int currentSubArraySum = nums[start];
            // Inner loop to check the next elements forming an ascending subarray

            for (int end = start + 1; end < nums.length && nums[end] > nums[end - 1]; end++) {
                currentSubArraySum += nums[end];
            }

            // Update maxSum if we find a larger ascending subarray sum
            maxSum = Math.max(maxSum, currentSubArraySum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int nums[] = {10, 20, 30, 5, 10, 50};
        System.out.println(maxAscendingSum(nums));
    }
}
