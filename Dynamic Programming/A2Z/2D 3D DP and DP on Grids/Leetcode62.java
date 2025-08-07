public class Leetcode62{
      public static int solve(int i, int j, int m, int n){
            if(i<0 || i>=m || j<0 || j>=n){
                  return 0;
            }

            if(i == m-1 && j == n-1){
                  return 1;
            }

            int right = solve(i, j+1, m, n);
            int down = solve(i+1, j, m, n);

            return right + down;
      }
      public static int uniquePaths(int m, int n){
            return solve(0, 0, m, n);
      }
      public static void main(String[] args) {
            int m = 3, n = 7;
            System.out.println(uniquePaths(m, n));
      }
}