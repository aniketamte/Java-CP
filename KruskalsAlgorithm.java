public class KruskalsAlgorithm {
      static class Edge implements Comparable<Edge>{
            int src;
            int dest;
            int wt;

            public Edge(int s, int d, int w){
                  this.src = s;
                  this.dest = d;
                  this.wt = w;
            }
            @Override
            public int compareTo(Edge e2){
                  return this.wt - e2.wt;
            }
      }
}
