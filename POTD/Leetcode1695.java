
import java.util.Arrays;
import java.util.HashSet;

public class Leetcode1695 {
      // Approach 1
      public static int maximumUniqueSubarray(int[] nums) {
            int n = nums.length;
            HashSet<Integer> set = new HashSet<>();
            int i = 0, j = 0, sum = 0, result = 0;
            while (j < n) {
                  if (!set.contains(nums[j])) {
                        sum += nums[j];
                        result = Math.max(result, sum);
                        set.add(nums[j]);
                        j++;
                  } else {
                        while (i < n && set.contains(nums[j])) {
                              sum -= nums[i]; // remove the leftmost element
                              set.remove(nums[i]);
                              i++;
                        }
                  }
            }
            return result;
      }

      // Approach 2

      public static int maximumUniqueSubarray2(int[] nums) {
            int n = nums.length;

            int[] cus = new int[n];
            cus[0] = nums[0];
            for (int i = 1; i < n; i++)
                  cus[i] = cus[i - 1] + nums[i];

            int[] mp = new int[10001];
            Arrays.fill(mp, -1);

            int maxS = 0;
            int i = 0;
            int j = 0;

            while (j < n) {
                  i = Math.max(i, mp[nums[j]] + 1);
                  int jthSum = cus[j];
                  int ithSum = i - 1 < 0 ? 0 : cus[i - 1];
                  maxS = Math.max(maxS, jthSum - ithSum);
                  mp[nums[j]] = j;

                  j++;
            }

            return maxS;
      }

      public static void main(String[] args) {
            int nums[] = { 4, 2, 4, 5, 6 };
            System.out.println(maximumUniqueSubarray(nums));
            System.out.println(maximumUniqueSubarray2(nums));
      }
}
