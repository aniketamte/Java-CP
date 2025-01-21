import java.util.ArrayList;

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
      static void createGraph(ArrayList<Edge> edges){
            //edges
            edges.add(new Edge(0, 1, 10));
            edges.add(new Edge(0, 2, 15));
            edges.add(new Edge(0, 3, 30));
            edges.add(new Edge(1, 3, 40));
            edges.add(new Edge(2, 3, 50));
      }
}