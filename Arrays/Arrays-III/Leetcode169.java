public class Leetcode169 {
      public static int majorityElement(int[] nums){
            int count = 0;
            int maj = nums[0];
            int n = nums.length;

            for(int i=1; i<n; i++){
                  if(nums[i] == maj){
                        count++;
                  } else if(count == 0){
                        maj = nums[i];
                  } else{
                        count--;
                  }
            }
            return maj;
      }
      public static void main(String[] args) {
            int nums[] = {3,2,3};
            System.out.println(majorityElement(nums));
      }
}
