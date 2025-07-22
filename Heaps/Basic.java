import java.util.PriorityQueue;

public class Basic {
      public static void main(String[] args) {
            // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());  //print in reverse order

            PriorityQueue<Integer> pq = new PriorityQueue<>(); //print in ascending order
            
            pq.add(3);
            pq.add(4);
            pq.add(1);
            pq.add(7);

            while(!pq.isEmpty()){
                  System.out.println(pq.peek());
                  pq.remove();
            }
      }
}
