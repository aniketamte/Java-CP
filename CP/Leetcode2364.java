
import java.util.HashMap;
import java.util.Map;

public class Leetcode2364 {

      //Count Number of Bad Pairs

    public static long countBadPairs(int[] nums) {
        long badPairs = 0;
        Map<Integer, Integer> diffCount = new HashMap<>();

        for (int pos = 0; pos < nums.length; pos++) {
            int diff = pos - nums[pos];

            // Count of previous positions with same difference
            int goodPairsCount = diffCount.getOrDefault(diff, 0);

            // Total possible pairs minus good pairs = bad pairs
            badPairs += pos - goodPairsCount;

            // Update count of positions with this difference
            diffCount.put(diff, goodPairsCount + 1);
        }

        return badPairs;
    }

    public static void main(String[] args) {
        int nums[] = {4, 1, 3, 3};
        System.out.println(countBadPairs(nums));
    }
}
