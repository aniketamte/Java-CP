public class Stack {
      private int[] data; // array to store the stack elements
      private static final int DEFAULT_SIZE = 10; // default size of the stack

      int ptr = -1;

      public Stack(){
            this(DEFAULT_SIZE); // call the constructor with default size
      }

      public Stack(int size){
            this.data = new int[size]; // initialize the array with the given size
      }

      public boolean push(int item){
            if(isFull()){
                  System.out.println("Stack is full");
                  return false;
            }
            ptr++;
            data[ptr] = item;
            return true;
      }

      public int pop() throws Exception{
            if(isEmpty()){
                  throw new Exception("Cannot pop from an empty stack");
            }
            int removed = data[ptr];
            ptr--;
            return removed;
      }

      public int peek() throws Exception{
            if (isEmpty()) {
                  throw new Exception("Cannot peek from an empty stack");
            }
            return data[ptr];
      }

      private boolean isFull(){
            return ptr == data.length - 1; //ptr is at the last index of the array
      }

      private boolean isEmpty(){
            return ptr == -1; // if ptr is -1, the stack is empty
      }

      public static void main(String[] args) {
            Stack stack = new Stack();
            stack.push(1);
            stack.push(2);
            
      }
}
