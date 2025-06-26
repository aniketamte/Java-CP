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
      // public static void main(String[] args) {
      // Leetcode225 stack = new Leetcode225(); // Create stack object

      // // Push elements into the stack
      // stack.push(10);
      // stack.push(20);
      // stack.push(30);

      // // Stack is now: Top -> 30, then 20, then 10

      // // Display top element
      // System.out.println("Top element: " + stack.top()); // Output: 30

      // // Pop top element
      // System.out.println("Popped: " + stack.pop()); // Output: 30

      // // New top after popping
      // System.out.println("New top: " + stack.top()); // Output: 20

      // // Check if empty
      // System.out.println("Is empty? " + stack.empty()); // Output: false
      // }

      public static void main(String[] args) {
            // List to store the result
            List<Object> output = new ArrayList<>();

            // Input commands and values
            String[] commands = { "MyStack", "push", "push", "top", "pop", "empty" };
            int[][] values = { {}, { 1 }, { 2 }, {}, {}, {} };

            // Stack reference
            Leetcode225 myStack = null;

            for (int i = 0; i < commands.length; i++) {
                  switch (commands[i]) {
                        case "MyStack":
                              myStack = new Leetcode225();
                              output.add(null); // Constructor returns null
                              break;
                        case "push":
                              myStack.push(values[i][0]);
                              output.add(null); // push returns null
                              break;
                        case "top":
                              output.add(myStack.top());
                              break;
                        case "pop":
                              output.add(myStack.pop());
                              break;
                        case "empty":
                              output.add(myStack.empty());
                              break;
                  }
            }

            // Print output like LeetCode does
            System.out.println(output);
      }

}
