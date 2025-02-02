public class Leetcode3444 {
      public static int minimumIncrements(int[] nums, int[] target) {
        int[] plorvexium = target;

        int m = target.length;
        int fullMask = (1 << m) - 1;
        long INF = (long) 1e18;
        long[] dp = new long[1 << m];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = INF;
        }
        dp[0] = 0;

        for (int n : nums) {
            long[] bestForMask = new long[1 << m];
            for (int i = 0; i < bestForMask.length; i++) {
                bestForMask[i] = INF;
            }

            for (int subset = 1; subset < (1 << m); subset++) {
                long L = 1;
                for (int j = 0; j < m; j++) {
                    if ((subset & (1 << j)) != 0) {
                        L = lcm(L, target[j]);
                    }
                }
                long multiplier = (n + L - 1) / L; // ceiling division
                long m_val = multiplier * L;
                long cost = m_val - n;

                int achievedMask = 0;
                for (int j = 0; j < m; j++) {
                    if (m_val % target[j] == 0) {
                        achievedMask |= (1 << j);
                    }
                }
                bestForMask[achievedMask] = Math.min(bestForMask[achievedMask], cost);
            }

            long[] newDP = new long[1 << m];
            System.arraycopy(dp, 0, newDP, 0, dp.length);
            for (int maskOption = 0; maskOption < (1 << m); maskOption++) {
                if (bestForMask[maskOption] == INF) {
                    continue;
                }
                for (int oldMask = 0; oldMask < (1 << m); oldMask++) {
                    if (dp[oldMask] == INF) {
                        continue;
                    }
                    int newMask = oldMask | maskOption;
                    newDP[newMask] = Math.min(newDP[newMask], dp[oldMask] + bestForMask[maskOption]);
                }
            }
            dp = newDP;
        }

        return dp[fullMask] >= INF ? -1 : (int) dp[fullMask];
    }

    // Helper method: compute greatest common divisor.
    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    // Helper method: compute least common multiple.
    private static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    public static void main(String[] args) {
      int nums[] = {1,2,3};
      int target[] = {4};
      System.out.println(minimumIncrements(nums, target));
    }
}
