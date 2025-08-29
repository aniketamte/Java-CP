import java.util.*;
public class Leetcode673 {
    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        int[] t = new int[n];
        int[] count = new int[n];
        Arrays.fill(t, 1);
        Arrays.fill(count, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (t[i] == t[j] + 1) {
                        count[i] += count[j];
                    } else if (t[i] < t[j] + 1) {
                        t[i] = t[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
        }

        int maxVal = Arrays.stream(t).max().getAsInt();

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (t[i] == maxVal) {
                result += count[i];
            }
        }

        return result;
    }
    public static void main(String[] args) {
      int nums[] = {1, 3, 5, 4, 7};
      System.out.println(findNumberOfLIS(nums));
    }
}
