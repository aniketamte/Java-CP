
import java.util.ArrayList;
import java.util.List;

public class Leetcode39 {

      //Leetcode : 39 --->  Combination Sum

    private static void findCombinations(int ind, int arr[], int target, List<List<Integer>> ans, List<Integer> ds) {
        // Base case: if the target is met, add the combination to the answer
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        // Ensure that the index does not go out of bounds
        if (ind >= arr.length) {
            return;
        }

        // If the current number can be used, include it
        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            findCombinations(ind, arr, target - arr[ind], ans, ds); // Stay at the same index for unlimited usage
            ds.remove(ds.size() - 1); // Backtrack
        }

        // Move to the next index
        findCombinations(ind + 1, arr, target, ans, ds);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
        int candidates[] = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }
}
