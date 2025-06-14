import java.util.*;

public class BFS {
      public static int findCircleNum(int[][] isConnected){
            int n = isConnected.length;
            boolean[] visited = new boolean[n];
            int count = 0;
            for (int i = 0; i < n; i++) {
                  if (!visited[i]) {
                        List<Integer> q = new ArrayList<>();
                        q.add(i);
                        visited[i] = true;
                        bfs(isConnected, q, visited);
                        count++;
                  }
            }
            return count;
      } 

      public static void bfs(int isConnected[][], List<Integer> q, boolean[] visited){
            if(q.isEmpty()) return;
            int city = q.remove(0);
            List<Integer> nextQueue = new ArrayList<>();
            for (int neighbor = 0; neighbor < isConnected.length; neighbor++) {
                  if (isConnected[city][neighbor] == 1 && !visited[neighbor]) {
                        visited[neighbor] = true;
                        nextQueue.add(neighbor);
                  }
            }

            bfs2(isConnected, q, nextQueue, visited);
      }
      
      private static void bfs2(int[][] isConnected, List<Integer> q, List<Integer> nextQueue, boolean[] visited) {
            if (!nextQueue.isEmpty()) {
                  q.addAll(nextQueue);
            }
            bfs(isConnected, q, visited);
      }

      public static void main(String[] args) {
            int[][] isConnected = {
                        { 1, 1, 0 },
                        { 1, 1, 0 },
                        { 0, 0, 1 }
            };

            int result = findCircleNum(isConnected);
            System.out.println("Number of Provinces: " + result);
      }
}
