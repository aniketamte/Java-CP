public class Leetcode342 {
    public static boolean isPowerOfFour(int n) {
        while (n >= 4) {
            if (n % 4 != 0) {
                break;
            } else {
                n = n / 4;
            }
        }
        return n == 1;
    }

    public static void main(String[] args) {
        int n = 16;
        System.out.println(isPowerOfFour(n));
    }
}
