
import java.util.HashSet;

public class Leetcode1695 {
      //Approach 1
      public static int maximumUniqueSubarray(int[] nums) {
            int n = nums.length;
            HashSet<Integer> set = new HashSet<>();
            int i = 0, j = 0, sum = 0, result = 0;
            while (j < n){
                  if (!set.contains(nums[j])){
                        sum += nums[j];
                        result = Math.max(result, sum);
                        set.add(nums[j]);
                        j++;
                  } else{
                        while(i<n && set.contains(nums[j])){
                              sum -= nums[i]; //remove the leftmost element 
                              set.remove(nums[i]);
                              i++;
                        }
                  }
            }
            return result;
      }

      public static void main(String[] args) {
            int nums[] = {4,2,4,5,6};
            System.out.println(maximumUniqueSubarray(nums));
      }
}
