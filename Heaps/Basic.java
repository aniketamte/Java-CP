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

            PriorityQueue<Student> pq = new PriorityQueue<>(); //print in ascending order

            pq.add(new Student("A", 3));
            pq.add(new Student("B", 1));
            pq.add(new Student("C", 7));
            pq.add(new Student("D", 4));

            while(!pq.isEmpty()){
                  System.out.println(pq.peek().name + "->" + pq.peek().rank);
                  pq.remove();
            }
      }
}
