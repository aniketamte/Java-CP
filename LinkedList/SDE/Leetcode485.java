public class Leetcode485{
      public static int findMaxConsecutiveOnes(int[] nums){
            int currCount = 0;
            int maxCount = 0;

            for(int i=0; i<nums.length; i++){
                  if(nums[i] == 1){
                        currCount++;
                        maxCount = Math.max(currCount, maxCount);
                  } else{
                        currCount = 0;
                  }
            }
            return maxCount;
      }
      public static void main(String[] args) {
            int nums[] = {1,1,0,1,1,1};
            System.out.println(findMaxConsecutiveOnes(nums));
      }
}