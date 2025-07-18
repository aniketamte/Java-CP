public class Leetcode287 {
      public static int findDuplicate(int[] nums){
            int slow = nums[0];
            int fast = nums[0];

            slow = nums[slow];
            fast = nums[nums[fast]];

            //Detect cycle
            while(slow != fast){
                  slow = nums[slow];
                  fast = nums[nums[fast]];
            }

            //After detect slow start from 0
            slow = nums[0];
            while(slow != fast){
                  slow = nums[slow];
                  fast = nums[fast];
            }
            return fast;
      }
      public static void main(String[] args) {
            int[] nums = {1,3,4,2,2};
            System.out.println(findDuplicate(nums));
      }
}
