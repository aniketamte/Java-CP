public class DFS {
      static class Edge {
            int src;
            int dest;
            int weight;

            public Edge(int s, int d, int w) {
                  this.src = s;
                  this.dest = d;
                  this.weight = w;
            }
      }

      public static int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            int[] visited = new int[n];
            int count = 0;
            for (int i = 0; i<n; i++){
                  if (visited[i] == 0) {
                        dfs(i, visited, isConnected);
                        count++;
                  }
            }
            return count;
      }

      public static void dfs(int node, int vis[], int isConnected[][]){
            if (vis[node] == 1)
                  return;
            vis[node] = 1;
            for(int i=0; i<isConnected[node].length; i++){
                  if(isConnected[node][i] == 1){
                        dfs(i, vis, isConnected);
                  }
            }
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
