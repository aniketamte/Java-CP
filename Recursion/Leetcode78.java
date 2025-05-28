import java.util.ArrayList;
import java.util.List;

public class Leetcode78{
      private List<List<Integer>> result = new ArrayList<>();

    // Main method to run the program
    public static void main(String[] args) {
      Leetcode78 solution = new Leetcode78();

        // Example input
        int[] nums = {1, 2};

        // Call subsets method
        List<List<Integer>> subsets = solution.subsets(nums);

        // Print the result
        System.out.println("All subsets:");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }

    // Method to generate all subsets
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        solve(nums, 0, temp);
        return result;
    }

    // Recursive helper method for generating subsets
    private void solve(int[] nums, int idx, List<Integer> temp) {
        if (idx >= nums.length) {
            result.add(new ArrayList<>(temp));  // Add a copy of current subset
            return;
        }

        // Include current element
        temp.add(nums[idx]);
        solve(nums, idx + 1, temp);

        // Backtrack and exclude current element
        temp.remove(temp.size() - 1);
        solve(nums, idx + 1, temp);
    }
}