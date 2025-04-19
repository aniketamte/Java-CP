
public class Leetcode1749 {

      //Maximum Absolute Sum of Any Subarray
      //26-02-2025

    public static int maxAbsoluteSum(int[] nums) {
        int minPrefixSum = Integer.MAX_VALUE, maxPrefixSum = Integer.MIN_VALUE;
        int prefixSum = 0, maxAbsSum = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            minPrefixSum = Math.min(minPrefixSum, prefixSum);
            maxPrefixSum = Math.max(maxPrefixSum, prefixSum);

            if (prefixSum >= 0) {
                maxAbsSum = Math.max(
                        maxAbsSum,
                        Math.max(prefixSum, prefixSum - minPrefixSum)
                );
            } else if (prefixSum <= 0) {
                maxAbsSum = Math.max(
                        maxAbsSum,
                        Math.max(
                                Math.abs(prefixSum),
                                Math.abs(prefixSum - maxPrefixSum)
                        )
                );
            }
        }

        return maxAbsSum;
    }

    public static void main(String[] args) {
        int nums[] = {1, -3, 2, 3, -4};
        System.out.println(maxAbsoluteSum(nums));
    }
}
