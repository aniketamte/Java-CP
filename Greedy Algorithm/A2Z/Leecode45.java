public class Leecode45 {
      public static int jump(int[] nums){
            int n = nums.length;
            return solve(nums, 0, 0);
      }

      private static int solve(int nums[], int idx, int jumpss) {
            int n = nums.length;
            if(idx >= n-1){
                  return 0;
            }
            int min = Integer.MAX_VALUE;
            for(int i=1; i<=nums[idx]; i++){
                  int next = idx + i;
                  if(next < n){
                        int result = 1+solve(nums, next, jumpss + 1);
                        min = Math.min(min, result);
                  }
            }
            return min;
      }
      public static void main(String[] args) {
            int nums[] = {2, 3, 1, 1, 4};
            System.out.println(jump(nums));
      }
}
