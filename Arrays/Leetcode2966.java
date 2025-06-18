import java.util.Arrays;

public class Leetcode2966 {
    public static int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int result[][] = new int[n / 3][3];  // Each group of 3

        int index = 0;
        for (int i = 0; i <= n - 3; i += 3) {
            if (nums[i + 2] - nums[i] > k) {
                return new int[0][0];
            }
            result[index++] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {1, 3, 4, 8, 7, 9, 3, 5, 1};
        int k = 2;
        System.out.println(Arrays.deepToString(divideArray(nums, k)));
    }
}
