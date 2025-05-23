
import java.util.Stack;

public class DuplicateParenthesis {
      public static boolean isDuplicate(String str){
            Stack<Character> s = new Stack<>();
            for(int i=0; i<str.length(); i++){
                  char ch = str.charAt(i);
                  //Closing
                  if(ch == ')'){
                        int count = 0;
                        while(s.peek() != '('){
                              s.pop();
                              count++;
                        }
                        if(count < 1){
                              return true;  //Duplicate
                        } else{
                              s.pop(); //opening pair
                        }
                  } else{
                        //Opening, operator, operands
                        s.push(ch);
                  }
            }
            return false;
      }
      public static void main(String[] args) {
            String str = "((a+b))";  //True
            String str2 = "(a-b)";   //False
            System.out.println(isDuplicate(str2));
      }
}
