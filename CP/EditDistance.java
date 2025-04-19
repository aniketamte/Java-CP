
public class EditDistance {
    //Time complexity ---> O(n*m)

    public static int editDistance(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];

        //initialize
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0) {
                    //0th row
                    dp[i][j] = j;
                }
                if (j == 0) {
                    //0th column
                    dp[i][j] = i;
                }
            }
        }

        //bottom up approach
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    //same condition
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //Different Condition

                    int add = dp[i][j - 1] + 1;
                    int delete = dp[i - 1][j] + 1;
                    int replace = dp[i - 1][j - 1] + 1;

                    //we are not compare 3 number at a time
                    dp[i][j] = Math.min(add, Math.min(delete, replace));
                }
            }
        }
        return dp[n][m];
        //convert n string ----> m string
    }

    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(editDistance(word1, word2));
    }
}
