
public class contest1 {
    //weekly contest 434 ====> Q1
    //Count Partitions with Even Sum Difference

    public static int countEvenSumDifferencePartitions(int[] nums) {
        int n = nums.length;

        // Calculate the total sum of the array
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        int count = 0;

        // Iterate through the array to calculate partitions
        for (int i = 0; i < n - 1; i++) {
            leftSum += nums[i];
            int rightSum = totalSum - leftSum;

            // Check if the difference between leftSum and rightSum is even
            if ((leftSum - rightSum) % 2 == 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {10, 10, 3, 7, 6};
        System.out.println("Output: " + countEvenSumDifferencePartitions(nums1)); // Output: 4

        // Example 2
        int[] nums2 = {1, 2, 2};
        System.out.println("Output: " + countEvenSumDifferencePartitions(nums2)); // Output: 0

        // Example 3
        int[] nums3 = {2, 4, 6, 8};
        System.out.println("Output: " + countEvenSumDifferencePartitions(nums3)); // Output: 3
    }
}
