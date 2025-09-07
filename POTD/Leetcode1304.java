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

    public static void main(String[] args) {
        int n = 5;
        System.out.println(Arrays.toString(sumZero(n)));
    }
}
