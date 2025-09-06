public class leetcode238 {

    public static int[] productExceptSelf(int[] nums) {
        int right[] = new int[nums.length];
        int prod = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            prod *= nums[i];
            right[i] = prod;
        }
        prod = 1;
        int res[] = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            int lp = prod;
            int rp = right[i + 1];
            res[i] = lp * rp;
            prod *= nums[i];
        }
        res[nums.length - 1] = prod;
        return res;
    }

    public static void main(String[] args) {
        int nums[]= {1, 2, 3, 4};
        System.out.println(productExceptSelf(nums));
    }
}
