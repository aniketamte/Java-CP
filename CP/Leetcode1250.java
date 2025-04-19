public class Leetcode1250{
      public static boolean isGoodArray(int[] nums) {
        int tempGCD = nums[0];
        int i = 0;
        while (i < nums.length) {
            tempGCD = gcd(tempGCD, nums[i]);
            i++;
            if (tempGCD == 1) {
                return true;
            }
        }
        return false;
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a; 
        }else {
            return gcd(b, (a % b));
        }
    }
    public static void main(String[] args) {
        int nums[] = {12,5,7,23};
        System.out.println(isGoodArray(nums));
    }
}