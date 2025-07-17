public class Leetcode3201 {
      public static int maximumLength(int[] nums) {
            int n = nums.length;

            int countEven = 0;
            int countOdd = 0;
            for(int num : nums){
                  if(num % 2 == 0){
                        countEven++;
                  } else{
                        countOdd++;
                  }
            }

            int parity = nums[0]%2;
            int alternating = 1;
            for(int i=0; i<n; i++){
                  int currParity = nums[i]%2;
                  if(currParity != parity){
                        alternating++;
                        parity=currParity;
                  }
            }
            return Math.max(alternating, Math.max(countEven, countOdd));
      }

      //Solve using recursion
      public static int maximumLengthRec(int[] nums){
            int n = nums.length;

            int maxSubLength = 0;

            maxSubLength = Math.max(maxSubLength, LIS(nums, 0, -1, 0)); //%2 == 0
            maxSubLength = Math.max(maxSubLength, LIS(nums, 0, -1, 1)); //%2 != 1

            return maxSubLength;
      }

      public static int LIS(int[] nums, int index, int prev, int mod){
            if(index >= nums.length){
                  return 0;
            }

            int take = 0;
            int skip = 0;

            //take
            if(prev == -1 || (nums[prev] + nums[index]) % 2 == mod){
                  take = 1 + LIS(nums, index + 1, index, mod);
            }

            //skip
            skip = LIS(nums, index + 1, prev, mod);
            return Math.max(take, skip);
      }

      public static void main(String[] args) {
            int[] nums = {1,2,1,1,2,1,2};
            System.out.println(maximumLength(nums));
            System.out.println(maximumLengthRec(nums));
      }
}
