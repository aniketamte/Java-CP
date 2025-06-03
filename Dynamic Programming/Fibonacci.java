public class Fibonacci {
      public static void fib(int n, int fib[]){
            // Bottom - Up Approach
            for(int i=2; i<=n; i++){
                  fib[i] = fib[i-1] + fib[i-2];
            }
            System.out.println("Fibonacci Series using DP");
            for(int i=0; i<=n; i++){
                  System.out.print(fib[i] + " ");
            }
      }
      public static void main(String[] args) {
            int n = 10;
            int fib[] = new int[n+1];
            fib[0] = 0;
            fib[1] = 1;
            fib(n, fib);
      }
}
