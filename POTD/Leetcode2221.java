public class Leetcode2221 {
      public static int triangularSum(int[] nums){
            int n = nums.length;
            while(n > 1){
                int temp[] = new int[n-1];
                for(int i=0; i<n-1; i++){
                  temp[i] = (nums[i] + nums[i+1]) % 10;
                }
                nums = temp;
                n--;
            }
            return nums[0];
      }
      public static void main(String[] args) {
            int nums[] = {1, 2, 3, 4, 5};
            System.out.println(triangularSum(nums));
      }
}
