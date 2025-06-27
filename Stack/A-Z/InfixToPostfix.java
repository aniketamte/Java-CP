import java.util.*;

public class InfixToPostfix {

      // Precedence method
      static int precedence(char ch) {
            switch (ch) {
                  case '+':
                  case '-':
                        return 1;
                  case '*':
                  case '/':
                  case '%':
                        return 2;
                  case '^':
                        return 3;
            }
            return -1;
      }

      // Check if operator is right-associative
      static boolean isRightAssociative(char op) {
            return op == '^';
      }

      // Main method to convert infix to postfix
      static String infixToPostfix(String expr) {
            StringBuilder result = new StringBuilder();
            Stack<Character> stack = new Stack<>();

            for (char ch : expr.toCharArray()) {
                  if (Character.isLetterOrDigit(ch)) {
                        result.append(ch); // Operand
                  } else if (ch == '(') {
                        stack.push(ch);
                  } else if (ch == ')') {
                        while (!stack.isEmpty() && stack.peek() != '(') {
                              result.append(' ').append(stack.pop());
                        }
                        stack.pop(); // remove '('
                  } else { // Operator
                        result.append(' ');
                        while (!stack.isEmpty() && stack.peek() != '(' &&
                                    (precedence(stack.peek()) > precedence(ch) ||
                                                (precedence(stack.peek()) == precedence(ch)
                                                            && !isRightAssociative(ch)))) {
                              result.append(stack.pop()).append(' ');
                        }
                        stack.push(ch);
                  }
            }

            while (!stack.isEmpty()) {
                  result.append(' ').append(stack.pop());
            }

            return result.toString().trim();
      }

      public static void main(String[] args) {
            String infix = "a+b*(c^d-e)^(f+g*h)-i";
            String postfix = infixToPostfix(infix);
            System.out.println("Postfix Expression: " + postfix);
      }
}
