import java.util.*;

public class Fibonacci {
      public static void fib(int n, int fib[]) {
            // Bottom - Up Approach
            for (int i = 2; i <= n; i++) {
                  fib[i] = fib[i - 1] + fib[i - 2];
            }
            System.out.println("Fibonacci Series using DP");
            for (int i = 0; i <= n; i++) {
                  System.out.print(fib[i] + " ");
            }
      }

      // Top - Down Approach ===> Memoization

      static int[] memo;

      public static int Fib(int n) {
            if (n == 0)
                  return 0;
            if (n == 1)
                  return 1;

            // If already computed, return from memo
            if (memo[n] != -1)
                  return memo[n];

            // Otherwise, compute and store in memo
            memo[n] = Fib(n - 1) + Fib(n - 2);
            return memo[n];
      }

      public static void main(String[] args) {
            int n = 10;
            int fib[] = new int[n + 1];
            fib[0] = 0;
            fib[1] = 1;
            fib(n, fib);

            memo = new int[n + 1];
            Arrays.fill(memo, -1);

            System.out.println("Fibonacci Series using Top-Down Memoization:");
            for (int i = 0; i <= n; i++) {
                  System.out.print(Fib(i) + " ");
            }
            System.out.println();
      }
}
