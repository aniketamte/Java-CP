import java.util.*;

public class Leetcode994 {
      public static int orangesRotting(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            Queue<int[]> q = new LinkedList<>();
            int freshCount = 0;

            for (int i = 0; i < m; i++) {
                  for (int j = 0; j < n; j++) {
                        if (grid[i][j] == 2) {
                              q.offer(new int[] { i, j });
                        } else if (grid[i][j] == 1) {
                              freshCount++;
                        }
                  }
            }

            if (freshCount == 0) {
                  return 0;
            }

            int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
            int time = 0;

            // Multi-source BFS
            while (!q.isEmpty()) {
                  int size = q.size();
                  while (size-- > 0) {
                        int[] current = q.poll();
                        int x = current[0];
                        int y = current[1];

                        for (int[] dir : directions) {
                              int newX = x + dir[0];
                              int newY = y + dir[1];

                              if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1) {
                                    grid[newX][newY] = 2; // Mark as rotten
                                    q.offer(new int[] { newX, newY });
                                    freshCount--;
                              }
                        }
                  }
                  time++;
            }

            return freshCount == 0 ? time - 1 : -1;
      }

      public static void main(String[] args) {
            int grid[][] = {
                        { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 }
            };
            System.out.println(orangesRotting(grid));
      }
}