public class Leetcode2210 {
      public static int countHillValley(int[] nums) {
            int n = nums.length;
            int count = 0;
            int i=0;
            int j=1;
            while(j+1 < n){
                  if((nums[i] < nums[j] && nums[j] > nums[j+1]) || (nums[i] > nums[j] && nums[j] < nums[j+1])) {
                        count++;
                        i = j;
                  }
                  j++;
            }
            return count;
      }
      public static void main(String[] args) {
            int[] nums = { 6, 6, 5, 5, 4, 1};
            System.out.println(countHillValley(nums)); // Output: 3     
      }
}
