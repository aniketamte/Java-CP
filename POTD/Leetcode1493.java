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

    //Sliding Window Approach

    public static int longestSubarray2(int[] nums){
      int zeroCount = 0;
      int maxLength = 0;

      int i=0;
      for(int j = 0; j<nums.length; j++){
            if(nums[j] == 0){
                  zeroCount++;
            }

            while(zeroCount > 1){
                  if(nums[i] == 0){
                        zeroCount--;
                  }
                  i++;
            }
            maxLength = Math.max(maxLength, j-i);
      }
      return maxLength;
    }

    //Better Sliding Window Approach
    public static int longestSubarray3(int[] nums){
      int last_zero_index = -1;
      int result = 0;

      int i = 0;
      int j = 0;

      while(j < nums.length){
            if(nums[j] == 0){
                  i = last_zero_index + 1;
                  last_zero_index = j;
            }
            result = Math.max(result, j-i);
            j++;
      }
      return result;
    }

    public static void main(String[] args) {
      int nums[] = {1, 1, 0, 1};
      System.out.println(longestSubarray(nums));
      System.out.println(longestSubarray2(nums));
      System.out.println(longestSubarray3(nums));
    }
}
