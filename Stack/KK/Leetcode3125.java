import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Leetcode3125 {
      private Stack<Integer> first;
      private Stack<Integer> second;

      public Leetcode3125() {
            first = new Stack<>();
            second = new Stack<>();
      }

      public void push(int item) {
            first.push(item);
      }

      public int pop() {
            while (!first.isEmpty()) {
                  second.push(first.pop());
            }
            int removed = second.pop();
            while (!second.isEmpty()) {
                  first.push(second.pop());
            }
            return removed;
      }

      public int peek() {
            while (!first.isEmpty()) {
                  second.push(first.pop());
            }
            int peeked = second.peek();
            while (!second.isEmpty()) {
                  first.push(second.pop());
            }
            return peeked;
      }

      public boolean empty() {
            return first.isEmpty();
      }

      public static void main(String[] args) {
            List<String> input = Arrays.asList("MyQueue", "push", "push", "peek", "pop", "empty");
            List<List<Integer>> values = Arrays.asList(
                        Arrays.asList(), // MyQueue
                        Arrays.asList(1), // push 1
                        Arrays.asList(2), // push 2
                        Arrays.asList(), // peek
                        Arrays.asList(), // pop
                        Arrays.asList() // empty
            );

            List<Object> output = new ArrayList<>();
            Leetcode3125 myQueue = null;

            for (int i = 0; i < input.size(); i++) {
                  String command = input.get(i);
                  List<Integer> val = values.get(i);

                  switch (command) {
                        case "MyQueue":
                              myQueue = new Leetcode3125();
                              output.add(null);
                              break;
                        case "push":
                              myQueue.push(val.get(0));
                              output.add(null);
                              break;
                        case "peek":
                              output.add(myQueue.peek());
                              break;
                        case "pop":
                              output.add(myQueue.pop());
                              break;
                        case "empty":
                              output.add(myQueue.empty());
                              break;
                  }
            }

            System.out.println(output);
      }
}
