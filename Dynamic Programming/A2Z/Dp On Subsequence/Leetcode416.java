
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode416 {

    public static int[][] t = new int[201][20001];

    public static boolean solve(List<Integer> nums, int i, int x) {
        if (x == 0) {
            return true;
        }

        if (i >= nums.size()) {
            return false;
        }

        if (t[i][x] != -1) {
            return t[i][x] == 1;
        }

        boolean take = false;
        if (nums.get(i) <= x) {
            take = solve(nums, i + 1, x - nums.get(i));
        }

        boolean not_take = solve(nums, i + 1, x);

        t[i][x] = (take || not_take) ? 1 : 0;
        return take || not_take;
    }

    public static boolean canPartition(int[] numsArr) {
        List<Integer> nums = new ArrayList<>();
        for (int num : numsArr) {
            nums.add(num);
        }

        int n = nums.size();
        int S = 0;
        for (int num : nums) {
            S += num;
        }

        if (S % 2 != 0) {
            return false;
        }

        for (int[] row : t) {
            Arrays.fill(row, -1);
        }

        int x = S / 2;

        return solve(nums, 0, x);
    }

    public static void main(String[] args) {
      int nums[] = {1, 5, 11, 5};
      System.out.println(canPartition(nums));
    }
}
