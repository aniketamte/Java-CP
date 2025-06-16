public class Leetcode2016 {
      public static int maximumDifference(int[] nums){
            int i=0;
            int max = 0;

            for(int j=1; j<nums.length; j++){
                  if(j>i && nums[j]>nums[i]){
                        int temp = nums[j] - nums[i];
                        if(temp > max){
                              max = temp;
                        }
                  } else{
                        i=j;
                  }
            }
            if(max == 0){
                  return -1;
            }
            return max;
      }
      public static void main(String[] args) {
            int[] nums = {7,1,5,4};
            System.out.println(maximumDifference(nums));
      }
}
