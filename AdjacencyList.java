
import java.util.ArrayList;

public class AdjacencyList {

    static class Edge {

        int src;
        int dest;
        int weight;

        //constructor
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }

    public static void main(String[] args) {
        //V=vertex
        int V = 5;

        //int arr[] = new arr[v];
        ArrayList<Edge>[] graph = new ArrayList[V];

        //null -> empty arrayList
        //each vertex edges is store in arrayList
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        //0 - vertex
        graph[0].add(new Edge(0, 1, 5));

        //1 - vertex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        //2-vertex
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 1));

        //3-vertex
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        //4-vertex
        graph[4].add(new Edge(4, 4, 2));

        //for loop is used for store 2's neighbour

        for(int i=0; i<graph[2].size(); i++){
            Edge e = graph[2].get(i);
            System.out.print(e.dest + " ");
        }
    }
}
