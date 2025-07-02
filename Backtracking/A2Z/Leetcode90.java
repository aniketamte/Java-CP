import java.util.*;
public class Leetcode90 {
      public static List<List<Integer>> subsetsWithDup(int[] nums){
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            find(res, nums, new ArrayList<>(), 0);
            return res;
      }
      public static void find(List<List<Integer>> res, int nums[], List<Integer> temp, int start){
            res.add(new ArrayList<>(temp));
            for(int i = start; i < nums.length; i++){
                  if(i > start && nums[i] == nums[i-1]){
                        continue;
                  }
                  temp.add(nums[i]);
                  find(res, nums, temp, i+1);
                  temp.remove(temp.size()-1);
            }
      }
      public static void main(String[] args) {
            int[] nums = {1,2,2};
            System.out.println(subsetsWithDup(nums));
      }
}
