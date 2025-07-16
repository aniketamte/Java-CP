public class Leetcode1004 {
      public static int longestOnes(int[] nums, int k) {
            int left = 0, right = 0, zeros = 0, maxLength = 0;
            while (right < nums.length){
                  if (nums[right] == 0){
                        zeros++;
                  }
                  if( zeros > k){
                        if (nums[left] == 0){
                              zeros--;
                        }
                        left++;
                  }
                  if(zeros <= k){
                        int length = right - left + 1;
                        maxLength = Math.max(maxLength, length);
                  }
                  right++;
            }
            return maxLength;
      }
      public static void main(String[] args) {
            int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
            int k = 2;
            System.out.println(longestOnes(nums, k));
      }
}
