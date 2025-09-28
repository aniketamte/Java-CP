public class Leetcode5 {
	public static boolean solve(String s, int i, int j, Boolean dp[][]){
            if(i >= j){
                  return true;
            }
            if (dp[i][j] != null){
                return dp[i][j];
            }
            if(s.charAt(i) == s.charAt(j)){
                  dp[i][j] = solve(s, i+1, j-1, dp);
            } else{
                  dp[i][j] = false;
            }
            return dp[i][j];
      }
      
      public static String longestPalindrome(String s){
            int n = s.length();
            Boolean dp[][] = new Boolean[n][n];
            int maxLength = Integer.MIN_VALUE;
            int startingPoint = 0;
            for(int i=0; i<n; i++){
                  for(int j=i; j<n; j++){
                        if(solve(s, i, j, dp)){
                              if(j-i+1 > maxLength){
                                  maxLength = j - i + 1;
                                  startingPoint = i;
                              }
                        }
                  }
            }
            return s.substring(startingPoint, startingPoint + maxLength);
      }
      
      public static String longestPalindrome2(String s){
            int n = s.length();
            Boolean dp[][] = new Boolean[n][n];
            int maxLength = 0;
            int startingPoint = 0;

            for(int i=0; i<n; i++){ //Diagonal Elements
                  dp[i][i] = true;
                  maxLength = 1;
            }

            for(int L=2; L<=n; L++){
                  for(int i=0; i<n-L+1; i++){
                        int j = i + L - 1;
                        if(s.charAt(i) == s.charAt(j) && L == 2){
                              dp[i][j] = true;
                              maxLength = 2;
                              startingPoint = i;
                        } else if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true){
                              dp[i][j] = true;
                              if(j-i+1 > maxLength){
                                    maxLength = j-i+1;
                                    startingPoint = i;
                              }
                        } else{
                              dp[i][j] = false;
                        }
                  }
            }
            return s.substring(startingPoint, startingPoint + maxLength);
      }

      public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s)); // Output: "bab" or "aba" 
        System.out.println(longestPalindrome2(s));
      }
}
