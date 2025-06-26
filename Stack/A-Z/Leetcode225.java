import java.util.*;

// File name: Leetcode225
public class Leetcode225 {

      Queue<Integer> queue; // Queue to simulate stack

      // Constructor to initialize the queue
      public Leetcode225() {
            queue = new LinkedList<>();
      }

      // Push operation to add element on top of the stack
      public void push(int x) {
            queue.add(x); // Add element to queue

            // Reverse the queue by rotating existing elements behind new one
            for (int i = 1; i < queue.size(); i++) {
                  queue.add(queue.peek()); // put front element at the back
                  queue.remove(); // remove it from front
            }
      }

      // Pop operation to remove and return the top of stack
      public int pop() {
            return queue.remove(); // remove from front (top of stack)
      }

      // Top operation to return the top element without removing it
      public int top() {
            return queue.peek(); // peek at the front (top of stack)
      }

      // Check if stack is empty
      public boolean empty() {
            return queue.isEmpty(); // check if queue is empty
      }

      // Main method to test the stack
      public static void main(String[] args) {
            Leetcode225 stack = new Leetcode225(); // Create stack object

            // Push elements into the stack
            stack.push(10);
            stack.push(20);
            stack.push(30);

            // Stack is now: Top -> 30, then 20, then 10

            // Display top element
            System.out.println("Top element: " + stack.top()); // Output: 30

            // Pop top element
            System.out.println("Popped: " + stack.pop()); // Output: 30

            // New top after popping
            System.out.println("New top: " + stack.top()); // Output: 20

            // Check if empty
            System.out.println("Is empty? " + stack.empty()); // Output: false
      }
}
