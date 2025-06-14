import java.util.*;
public class Leetcode994 {
      public class Pair {
            public int first;
            public int second;

            public Pair(int first, int second) {
                  this.first = first;
                  this.second = second;
            }
      }
        
      public static int orangesRotting(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            Queue<Pair> q;
            int freshCount = 0;

            for(int i=0; i<m; i++){
                  for(int j=0; j<n; j++){
                        if(grid[i][j] == 2){
                              q.push({i, j});
                        } else if(grid[i][j] == 1){
                              freshCount++;
                        }
                  }
            }
            if(freshCount == 0){
                  return 0;
            }
            int min = 0;
            while(!q.isEmpty()){
                  int n = q.size();
                  while(n--){
                        Pair p = q.poll();
                        q.pop();
                  }
            }
      }
}
