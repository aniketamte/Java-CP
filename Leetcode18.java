import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Leetcode18 {
      public static List<List<Integer>> fourSum(int[] nums, int target){
            int n = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);

            HashSet<String> unique = new HashSet<>();
            
            for(int i=0; i<n-3; i++){
                  for(int j=i+1; j<n-2; j++){
                        int li = j+1;
                        int ri = n-1;

                        while (li < ri) {
                          int sum = nums[i] + nums[j] + nums[li] + nums[ri];

                          if (sum < target) {
                              li++;
                          } else if (sum > target) {
                              ri--;
                          } else {
                              StringBuilder sb = new StringBuilder();

                              sb.append(nums[i]);
                              sb.append(nums[j]);
                              sb.append(nums[li]);
                              sb.append(nums[ri]);

                              String code = sb.toString();

                              if(unique.contains(code) == false){
                                    unique.add(code);
                                  res.add(Arrays.asList(nums[i], nums[j], nums[li], nums[ri]));
                              }
                              li++;
                              ri--;
                          }
                      }
                  }
            }

            return res;
      }
      public static void main(String[] args) {
            int nums[] = {1, 0, -1, 0, -2, 2};
            int target = 0;
            System.out.println(fourSum(nums, target));
      }
}
