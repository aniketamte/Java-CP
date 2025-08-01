import java.util.*;
public class CreateGraph {
      // ArrayList<Edge> graph[]
      // Edge = (src, dest, weight)

      static class Edge{
            int src;
            int dest;
            int weight;

            public Edge(int s, int d, int w){
                  this.src = s;
                  this.dest = d;
                  this.weight = w;
            }
      }

      public static void main(String[] args) {
            int V = 5;
            ArrayList<Edge> graph[] = new ArrayList[V];

            //null => empty ArrayList

            for(int i=0; i<V; i++){
                  graph[i] = new ArrayList<>();
            }

            //0 vertex
            graph[0].add(new Edge(0, 1, 5));

            //1 vertex
            graph[1].add(new Edge(1, 0, 5));
            graph[1].add(new Edge(1, 2, 1));
            graph[1].add(new Edge(1, 3, 3));

            //2 vertex
            graph[2].add(new Edge(2, 1, 1));
            graph[2].add(new Edge(2, 3, 1));
            graph[2].add(new Edge(2, 4, 2));

            //3 vertex
            graph[3].add(new Edge(3, 1, 3));
            graph[3].add(new Edge(3, 2, 1));

            //4 vertex
            graph[4].add(new Edge(4, 2, 2));

            //0's neighbour
            for(int i=0; i<graph[0].size(); i++){
                  Edge e = graph[0].get(i);
                  System.out.println("0's neighbour: " + e.dest + " with weight: " + e.weight);
            }

            //1's neighbour
            for(int i=0; i<graph[1].size(); i++){
                  Edge e = graph[1].get(i);
                  System.out.println("1's neighbour: " + e.dest + " with weight: " + e.weight);
            }

            // 2's neighbour
            for (int i = 0; i < graph[2].size(); i++) {
                  Edge e = graph[2].get(i);
                  System.out.println("2's neighbour: " + e.dest + " with weight: " + e.weight);
            }
            
            //3's neighbour
            for(int i=0; i<graph[3].size(); i++){
                  Edge e = graph[3].get(i);
                  System.out.println("3's neighbour: " + e.dest + " with weight: " + e.weight);
            }
      }
}
