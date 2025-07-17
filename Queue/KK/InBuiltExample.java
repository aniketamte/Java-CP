import java.util.*;

public class InBuiltExample {
      public static void main(String[] args) {
            Queue<Integer> que = new LinkedList<>();
            que.add(10);
            que.add(20);
            que.add(30);
            que.add(40);
            que.add(50);
            que.add(60);
            que.add(70);
            que.add(80);
            que.add(90);

            System.out.println(que);
            System.out.println(que.peek());
            System.out.println(que.remove());
            System.out.println(que);

            // Doubly ended queue - Deque
            Deque<Integer> deque = new ArrayDeque<>();
            deque.add(10);
            deque.add(20);
            deque.add(30);
            deque.add(40);
            deque.add(50);
            System.out.println(deque);
            System.out.println(deque.poll());
            System.out.println(deque.offer(900)); // work as add in queue (id deque.add() method is not available then
                                                  // use offer() method)
            System.err.println(deque);
            System.out.println(deque.peek());
            deque.add(91);
            System.err.println(deque);
            deque.addLast(92);
            System.err.println(deque);
            deque.addFirst(93);
            System.err.println(deque);
            System.out.println(deque.pollFirst());
            System.err.println(deque);
            System.out.println(deque.pollLast());// remove last element
            System.err.println(deque);

            //In deque we can insert from first and last both and also remove from first and last both 
      }
}
