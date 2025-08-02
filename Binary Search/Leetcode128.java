public class Leetcode128 {
      public static int smallestDivisor(int[] nums, int threshold) {
            int n = nums.length; // size of numsay.
            if (n > threshold)
                  return -1;
            // Find the maximum element:
            int maxi = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                  maxi = Math.max(maxi, nums[i]);
            }

            int low = 1, high = maxi;

            while(low <= high){
                  int mid = low + (high - low)/2;
                  if(sumByD(nums, mid) <= threshold){
                        high = mid - 1;
                  } else{
                        low = mid + 1;
                  }
            }
            return low;
      }
      
      public static int sumByD(int[] nums, int div) {
            int n = nums.length; // size of numsay
            // Find the summation of division values:
            int sum = 0;
            for (int i = 0; i < n; i++) {
                  sum += Math.ceil((double) (nums[i]) / (double) (div));
            }
            return sum;
      }
      public static void main(String[] args) {
            int nums[] = {1,2,5,9};
            int threshold = 6;
            System.out.println(smallestDivisor(nums, threshold));
      }
}
