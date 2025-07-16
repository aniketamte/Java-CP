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
      public static void main(String[] args) {
            int[] nums = {1,2,1,1,2,1,2};
            System.out.println(maximumLength(nums));
      }
}
