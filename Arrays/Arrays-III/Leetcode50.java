public class Leetcode50{
      public static double myPow(double x, long n){
            if(n == 0){
                  return 1;
            }
            if(n < 0){
                  return myPow(1/x, -n);
            }
            if(n % 2 == 0){
                  return myPow(x * x, n / 2);
            } else{
                  return x * myPow(x * x, (n-1) / 2);
            }
      }
      public static void main(String[] args) {
            float x = 2.00000f;
            long n = 10;
            System.out.println(myPow(x, n));
      }
}