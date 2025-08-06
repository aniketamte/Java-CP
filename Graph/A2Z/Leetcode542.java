import java.util.LinkedList;
import java.util.Queue;

public class Leetcode542 {
      static int m;
      static int n;
      static int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

      public static int[][] updateMatrix(int[][] mat) {
            m = mat.length;
            n = mat[0].length;

            int[][] result = new int[m][n];

            Queue<int[]> que = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                  for (int j = 0; j < n; j++) {
                        A
                        if (mat[i][j] == 0) {
                              result[i][j] = 0;
                              que.offer(new int[] { i, j });
                        } else {
                              result[i][j] = -1;
                        }
                  }
            }
            while (!que.isEmpty()) {
                  int[] cell = que.poll();
                  int i = cell[0];
                  int j = cell[1];

                  for (int[] dir : directions) {

                        int new_i = i + dir[0];
                        int new_j = j + dir[1];

                        if (new_i >= 0 && new_i < m && new_j >= 0 && new_j < n && result[new_i][new_j] == -1) {
                              result[new_i][new_j] = result[i][j] + 1;
                              que.add(new int[] { new_i, new_j });
                        }
                  }
            }

            return result;

      }

      public static void main(String[] args) {
            int mat[][] = {
                        { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 }
            };
            System.out.println(updateMatrix(mat));
      }
}
