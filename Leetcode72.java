
public class Leetcode72 {

      //Leetcode : 72 =====>  Edit Distance
      //Sove using Dynamic Programming (DP)
      //24-03-2025

    public static void print(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n + 1][m + 1];

        //initialize
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0) {
                    //row empty
                    dp[i][j] = j;
                }
                if (j == 0) {
                    //column empty
                    dp[i][j] = i;
                }
            }
        }

        //bottom up
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    //If last index character is same
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //If last index char is different
                    //then perform operation like add, replace, delete

                    int add = dp[i][j - 1] + 1;
                    int delete = dp[i - 1][j] + 1;
                    int replace = dp[i - 1][j - 1] + 1;
                    dp[i][j] = Math.min(add, Math.min(delete, replace));
                }
            }
        }
        print(dp);
        return dp[n][m];
    }

    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(minDistance(word1, word2));
    }
}
