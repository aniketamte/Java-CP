
import java.util.Arrays;

public class Leetcode1498 {
      public static int numSubseq(int[] nums, int target) {
            int M = 100000007;
            int n = nums.length;
            Arrays.sort(nums);
            int left = 0, right = n - 1;
            int result = 0;

            int pow[] = new int[n + 1];
            pow[0] = 1;
            for (int i = 1; i <= n; i++){
                  pow[i] = (int) ((long) pow[i - 1] * 2 % M);
            }

            while(left <= right){
                  if(nums[left] + nums[right] <= target){
                        int diff = right - left;
                        result = (result % M + pow[diff] % M) % M;
                        left++;
                  } else{
                        right--;
                  }
            }
            return result;
      }
      public static void main(String[] args) {
            int[] nums = {3, 4, 6, 8};
            int target = 10;
            System.out.println(numSubseq(nums, target));
      }
}
