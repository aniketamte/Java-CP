public class Leetcode1021 {
      public static String removeOuterParentheses(String s){
            int count = 0;
            StringBuilder sb = new StringBuilder();

            for(int i=0; i<s.length(); i++){
                  if(s.charAt(i) == '('){
                        if(count > 0){
                              sb.append('(');
                        }
                        count++;
                  } else{
                        count--;
                        if (count > 0) {
                          sb.append(')');
                      }
                  }
            }
            return sb.toString();
      }

      public static void main(String[] args) {
            String s = "(()())(())";
            System.out.println(removeOuterParentheses(s));
      }
}
