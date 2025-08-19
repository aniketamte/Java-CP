public class Leetcode2348 {
    public static long zeroFilledSubarray(int[] nums) {
      long result = 0;
      int i = 0;
      int n = nums.length;
      while(i<n){
            long length = 0;
            if(nums[i] == 0){
                  while(i<n && nums[i]==0){
                        i++;
                        length++;
                  }
            } else{
                  i++;
            }
            result += (length)*(length+1)/2;
      }
      return result;
    }
    public static void main(String[] args) {
      int nums[] = {1, 3, 0, 0, 2, 0, 0, 4};
      System.out.println(zeroFilledSubarray(nums));
    }
}
