public class Leetcode1143{

      //Solve using Recursion
      public static int LCS(String str1, String str2, int n, int m){
            if(n == 0 || m == 0){
                  return 0;
            }

            if(str1.charAt(n-1) == str2.charAt(m-1)){   //Same
                  return LCS(str1, str2, n-1, m-1)+ 1;
            } else{
                  //Different
                  int ans1 = LCS(str1, str2, n-1, m);
                  int ans2 = LCS(str1, str2, n, m-1);
                  return Math.max(ans1, ans2);
            }
      }


      // Solve using Memoization code Method

      public static int LCS2(String str1, String str2, int n, int m, int dp[][]) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if(dp[n][m] != -1){
            return dp[n][m];
        }

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {   //Same
            return dp[n][m] = LCS2(str1, str2, n-1, m-1, dp) + 1;
        } else {
            //Different
            int ans1 = LCS2(str1, str2, n-1, m, dp);
            int ans2 = LCS2(str1, str2, n, m-1, dp);
            return dp[n][m] = Math.max(ans1, ans2);
        }
    }
      public static void main(String[] args) {
            String str1 = "abcdge";
            String str2 = "abedg";
            int n = str1.length();
            int m = str2.length();
            
            //create 2D Array

            int dp[][] = new int[n+1][m+1];

            //initialization
            for(int i=0; i<n+1; i++){
                  for(int j=0; j<m+1; j++){
                        dp[i][j] = -1;
                  }
            }

            //lcs ==> "abdg"; length = 4

            System.out.println("Using Recursion Method");
            
            System.out.println(LCS(str1, str2, str1.length(), str2.length()));
            
            System.out.println("Using Memoization Method : ");
            System.out.println(LCS2(str1, str2, n, m, dp));
      }
}