import java.util.Stack;

public class InBuiltExamples {
      public static void main(String[] args) {
            Stack<Integer> stack = new Stack<>();

            stack.push(10);
            stack.push(20);
            stack.push(30);
            stack.push(40);
            stack.push(50);
            stack.push(60);
            stack.push(70);
            stack.push(80);
            stack.push(90);
            stack.push(100);

            System.out.println("Stack: " + stack);

            System.out.println("Peek: " + stack.peek());

            System.out.println("Pop: " + stack.pop());
            System.out.println("Stack: " + stack);

            System.out.println("Pop: " + stack.pop());
            System.out.println("Stack: " + stack);

            System.out.println("Pop: " + stack.pop());
            System.out.println("Stack: " + stack);

            System.out.println("Pop: " + stack.pop());
            System.out.println("Stack: " + stack);

            System.out.println("Pop: " + stack.pop());
            System.out.println("Stack: " + stack);
      }
}
