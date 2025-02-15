public class fibDP {
      public static int fibo(int n, int dp[]){
            //Tc ---> O(n)
          if (n == 0 || n == 1) {
              return n;
          }
          if(dp[n] != 0){ //fib[n] is already calculated
            return dp[n];
          }
          dp[n] = fibo(n-1, dp) + fibo(n-2, dp);
          return dp[n];
      }

      //Tabulataion Form
      public static int fibTabulation(int n){
            int dp[] = new int[n+1];
            dp[0]=0;
            dp[1]=1;
            for(int i=2; i<=n; i++){
                  dp[i]=dp[i-1]+dp[i-2];
            }
            return dp[n]; //ans;
      }
      public static void main(String[] args) {
            int n=5;
            int dp[] = new int[n+1];
            System.out.println(fibo(n, dp));
            System.out.println(fibTabulation(n));
      }
}
