import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode1547 {

    //Leetcode : 1547 ===> Minimum Cost to Cut a Stick
    //Rod cutting example
    //24-03-2025

     public static int minCost(int n, int[] cuts) {
        List<Integer> L = new ArrayList<>();
        for(int i : cuts) L.add(i); L.add(0); L.add(n);
        Collections.sort(L);
        int c = cuts.length;
        int[][] dp = new int[c + 1][c + 1];
        for(int A[] : dp) Arrays.fill(A, -1);
        // return f(dp, L, 1, c);
        return tab(L, c);
    }
    static int f(int[][] dp, List<Integer> L, int i, int j){
        // memoization
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int ind = i; ind <= j; ind++){
            int ans = L.get(j + 1) - L.get(i - 1) + f(dp, L, i, ind - 1) + f(dp, L, ind + 1, j);
            min = Math.min(ans, min);
        }
        return dp[i][j] = min;
    }
    static int tab(List<Integer> L, int c){
        // tabulation
        int[][] dp = new int[c + 2][c + 2];
        for(int i = c; i >= 1; i--){
            for(int j = 1; j <= c; j++){
                if(i > j) continue;
                int min = Integer.MAX_VALUE;
                for(int ind = i; ind <= j; ind++){
                    int ans = L.get(j + 1) - L.get(i - 1) + dp[i][ind - 1] + dp[ind + 1][j];
                    min = Math.min(ans, min);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][c];
    }

    public static void main(String[] args) {
        int cuts[] = {1,3,4,5};
        int n = 7;
        System.out.println(minCost(n, cuts));
    }
}
