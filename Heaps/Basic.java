import java.util.PriorityQueue;

public class Basic {
      static class Student implements Comparable<Student>{
            String name;
            int rank;

            public Student(String name, int rank){
                  this.name = name;
                  this.rank = rank;
            }

            @Override
            public int compareTo(Student other) {
                  return this.rank - other.rank;  // Sort by rank in ascending order 
            }
      }
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
