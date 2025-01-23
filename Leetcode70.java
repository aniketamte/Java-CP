
import java.util.Arrays;

public class Leetcode70 {
      //Leetcode 70
      
      //Using Recursion
      //This solution shows TLE on Leetcode after submitting code
      public static int countWays(int n){
            if(n==0){
                  return 1;
            }
            if(n<0){
                  return 0;
            }
            return countWays(n-1) + countWays(n-2);
      }

      //Memorization ---> O(n)
      public static int countWaysMemorization(int n, int ways[]) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (ways[n] != -1) {
            return ways[n];
        }
        ways[n] = countWaysMemorization(n - 1, ways) + countWaysMemorization(n - 2, ways);
        return ways[n];
    }

      public static void main(String[] args) {
            int n=5;
            int ways[] = new int[n+1];
            Arrays.fill(ways, -1);
            System.out.println(countWays(n));
            System.out.println(countWaysMemorization(n, ways));
      }
}
