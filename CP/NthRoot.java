
public class NthRoot {
    //The N-th root of an integer
    //28-02-2025

    public static int func(int mid, int n, int m) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * mid;
            if (ans > m) {
                return 2;
            }
        }
        if (ans == m) {
            return 1;
        }
        return 0;
    }

    public static int NthRoot(int n, int m) {
        // Use binary search on the answer space:
        int low = 1, high = m;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midN = func(mid, n, m);
            if (midN == 1) {
                return mid;
            } else if (midN == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 27;
        System.out.println(NthRoot(n, m));
    }
}
