public class stackusingLL {

      // Node class to represent each element in the stack
      static class Node {
            int data; // Data of the node
            Node next; // Pointer to next node

            Node(int data) {
                  this.data = data;
                  this.next = null;
            }
      }

      // Stack class implemented using Linked List
      static class Stack {
            Node head = null; // Head of the linked list (top of the stack)

            // Check if the stack is empty
            public boolean isEmpty() {
                  return head == null;
            }

            // Push operation: add element to the top of the stack
            public void push(int data) {
                  Node newNode = new Node(data);
                  newNode.next = head;
                  head = newNode;
            }

            // Pop operation: remove and return the top element
            public int pop() {
                  if (isEmpty()) {
                        System.out.println("Stack is empty");
                        return -1; // Error value
                  }
                  int top = head.data;
                  head = head.next;
                  return top;
            }

            // Peek operation: return the top element without removing
            public int peek() {
                  if (isEmpty()) {
                        System.out.println("Stack is empty");
                        return -1; // Error value
                  }
                  return head.data;
            }
      }

      // Main method
      public static void main(String[] args) {
            Stack s = new Stack(); // Create a new stack

            // Push elements to the stack
            s.push(1);
            s.push(2);
            s.push(3);
            s.push(4);
            s.push(5);
            s.push(6);

            // Pop and print elements until the stack is empty
            while (!s.isEmpty()) {
                  System.out.println("Top: " + s.peek());
                  s.pop();
            }
      }
}
