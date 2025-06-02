import java.util.*;
public class Leetcode90 {
      public void findSubsets(int ind, int nums[], List<Integer> ds, List<List<Integer>> ansList) {
            ansList.add(new ArrayList<>(ds));
            for (int i = ind; i < nums.length; i++) {
                  if (i != ind && nums[i] == nums[i - 1])
                        continue;
                  ds.add(nums[i]);
                  findSubsets(i + 1, nums, ds, ansList);
                  ds.remove(ds.size() - 1);
            }
      }

      public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ansList = new ArrayList<>();
            findSubsets(0, nums, new ArrayList<>(), ansList);
            return ansList;
      }

      public static void main(String[] args) {
            Leetcode90 obj = new Leetcode90(); // Create object
            int[] nums = { 1, 2, 2 };
            System.out.println("Input: " + Arrays.toString(nums));
            List<List<Integer>> output1 = obj.subsetsWithDup(nums); // Call method on object
            System.out.println("Output: " + output1);
      }
}