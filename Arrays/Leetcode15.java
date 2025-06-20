import java.util.*;
public class Leetcode15 {
      public static List<List<Integer>> threeSum(int[] nums){
            Arrays.sort(nums);
            List<List<Integer>> op = new ArrayList<>();
            for(int i=0; i<nums.length; i++){
                  if(i>0 && nums[i]==nums[i-1]){
                        continue;
                  }
                  int target = -nums[i];
                  int left = i+1, right = nums.length-1;
                  while(left < right){
                        int sum = nums[left] + nums[right];
                        if(sum == target){
                              op.add(Arrays.asList(nums[i], nums[left], nums[right]));
                              while (left < right && nums[left] == nums[left + 1])
                                    left++;
                              while (left < right && nums[right] == nums[right - 1])
                                    right--;
                              left++;
                              right--;
                        } else if (sum < target) {
                              left++;
                        } else {
                              right--;
                        }
                  }
            }
            return op;
      }
      public static void main(String[] args) {
            int[] nums = {-1,0,1,2,-1,-4};
            System.out.println(threeSum(nums));
      }
}
