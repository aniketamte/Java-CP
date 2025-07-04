public class GridWays {
      public static int gridWays(int i, int j, int n, int m) {
            // Base case
            if (i == n - 1 && j == m - 1) { // Condition for the destination cell(last cell)
                  return 1;
            } else if (i == n || j == m) { // Condition for out of bounds
                  return 0;
            }

            int w1 = gridWays(i + 1, j, n, m);
            int w2 = gridWays(i, j + 1, n, m);
            return w1 + w2;
      }

      public static void main(String[] args) {
            int n = 3;
            int m = 3;
            System.out.println(gridWays(0, 0, n, m));
      }
}
