import java.util.*;

public class Leetcode15 {

      // Method to find all unique triplets that sum up to zero
      public static List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums); // Sort the array for two-pointer approach
            int n = nums.length;

            if (n < 3) {
                  return result; // If less than 3 elements, return empty list
            }

            for (int i = 0; i < n; i++) {
                  // Skip duplicate values for the first number
                  if (i > 0 && nums[i] == nums[i - 1]) {
                        continue;
                  }

                  int n1 = nums[i];
                  int target = -n1; // We want to find two numbers that sum to -n1

                  // Call helper method to find two-sum pairs and add to result
                  twoSum(nums, target, i + 1, n - 1, result);
            }

            return result;
      }

      // Helper method to find pairs that sum to target using two-pointer approach
      public static void twoSum(int[] nums, int target, int i, int j, List<List<Integer>> result) {
            while (i < j) {
                  int sum = nums[i] + nums[j];

                  if (sum > target) {
                        j--;
                  } else if (sum < target) {
                        i++;
                  } else {
                        result.add(Arrays.asList(-target, nums[i], nums[j]));

                        // Skip duplicates
                        while (i < j && nums[i] == nums[i + 1])
                              i++;
                        while (i < j && nums[j] == nums[j - 1])
                              j--;

                        i++;
                        j--;
                  }
            }
      }

      // Main method to test the function
      public static void main(String[] args) {
            int[] nums = { -1, 0, 1, 2, -1, -4 };
            List<List<Integer>> triplets = threeSum(nums);
            System.out.println(triplets);
      }
}
