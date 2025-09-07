import java.util.Arrays;
public class Leetcode1304 {
    //Approach 1
    public static int[] sumZero(int n) {
        int res[] = new int[n];

        int start = 1;
        int i = 0;
        while (i + 1 < n) {
            res[i] = start;
            res[i + 1] = -start;

            i += 2;
            start++;
        }
        return res;
    }

    //Approach 2
    public static int[] sumZero2(int n) {
        int res[] = new int[n];
        int start = 1;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            res[i] = start;
            res[j] = -start;
            i++;
            j--;
            start++;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(Arrays.toString(sumZero(n)));
        System.out.println(Arrays.toString(sumZero2(n)));
    }
}
