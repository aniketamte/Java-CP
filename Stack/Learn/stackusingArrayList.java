import java.util.*;
public class stackusingArrayList {
      public static class stack{
            static ArrayList<Integer> list = new ArrayList<>();

            public static boolean isEmpty(){
                  return list.size() == 0;
            }

            //Push
            public static void push(int data){
                  list.add(data);
            }

            //Pop
            public static int pop(int data){
                  if(isEmpty()){
                        System.out.println("Stack is empty");
                  }
                  int pop = list.get(list.size()-1);
                  list.remove(list.size()-1);
                  return pop;
            }

            //Peek
            public static int peek(int data){
                  if (isEmpty()) {
                        System.out.println("Stack is empty");
                  }
                  return list.get(list.size() - 1);
            }
      }

      public static void main(String[] args) {
            Stack s = new Stack<>();
            s.push(1);
            s.push(2);
            s.push(3);
            s.push(4);
            s.push(5);
            s.push(6);

            while(!s.isEmpty()){
                  System.out.println(s.peek());
                  s.pop();
            }
      }
}
