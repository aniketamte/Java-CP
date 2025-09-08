import java.util.Arrays;
public class Leetcode1317 {
    //Approach - 1
    public static int[] getNoZeroIntegers(int n) {
        for (int a = 1; a <= n; a++) {
            int b = n - a;
            if (check(a) && check(b)) {
                return new int[]{a, b};
            }
        }
        return new int[0];
    }

    private static boolean check(int num) {
        while (num > 0) {
            if (num % 10 == 0) {
                return false;
            }
            num = num / 10;
        }
        return true;
    }

    //Approach 2
    public static int[] getNoZeroIntegers2(int n) {
        int a = n;
        int b = 0;
        int placeValue = 1;

        while (n > 1) {
            int take = 1;
            if (n % 10 == 1) {
                take = 2;
            }

            a = a - take * placeValue;
            b = b + take * placeValue;

            n = (n - take) / 10;

            placeValue *= 10;
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        int n = 2031;
        System.out.println(Arrays.toString(getNoZeroIntegers(n)));
        System.out.println(Arrays.toString(getNoZeroIntegers2(n)));
    }
}
