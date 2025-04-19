
public class countingtrees {

    //TC -----> O(n^2)
    public static int countBST(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            //Here we calculate Ci =?
            for (int j = 0; j < i; j++) {
                //Ci = Cj * Ci-j-1
                int leftSubtree = dp[j];
                int rightSubtree = dp[i - j - 1];
                dp[i] += leftSubtree * rightSubtree;
            }
        }
        print(dp);
        return dp[n];
    }

    public static void print(int dp[]) {
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(countBST(n));
    }
}
