public class Leetcode1493 {
    static int n;

    //Brute Force Approach
    public static int longestSubarray(int[] nums) {
        n = nums.length;
        int result = 0;
        int countZero = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                countZero++;
                result = Math.max(result, findMax(nums, i));
            }
        }

        if (countZero == 0) {
            return n - 1;
        }
        return result;
    }

    public static int findMax(int nums[], int skipIndex) {
        int currLength = 0;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            if (i == skipIndex) {
                continue;
            }

            if (nums[i] == 1) {
                currLength++;
                maxLength = Math.max(maxLength, currLength);
            } else {
                currLength = 0;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
      int nums[] = {1, 1, 0, 1};
      System.out.println(longestSubarray(nums));
    }
}
