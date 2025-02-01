public class Leetcode3151 {
      //Problem Of the Day ---> 01/02/2025
      //3151. Special Array I
      public static boolean isArraySpecial(int[] nums){
            for(int i=0; i<nums.length-1; i++){
                  if(nums[i]%2 == nums[i+1]%2){
                        return false;
                  }
            }
            return true;
      }
      public static void main(String[] args) {
            int nums[] = {4,3,1,6};
            System.out.println(isArraySpecial(nums));
      }
}
