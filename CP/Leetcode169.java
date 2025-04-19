

public class Leetcode169 {
      //Revision
      //SOLUTION 1 => O(1)
      public static int majorityElement(int nums[]){
            int candidate = nums[0];
            int count = 0;
            for(int i: nums){
                  if(i == candidate){
                        count++;
                  }else{
                        count--;
                        if(count == 0){
                              candidate = i;
                              count++;
                        }
                  }
            }
            return candidate;
      }
      public static void main(String[] args) {
            int nums[] = {3,2,3};
            System.out.println(majorityElement(nums));
      }
}
