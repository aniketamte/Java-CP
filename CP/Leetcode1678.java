public class Leetcode1678 {
      public static String interpret(String command){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<command.length(); i++){
                  if(command.charAt(i) == 'G'){
                        sb.append("G");
                  } else if(command.charAt(i) == '(' && command.charAt(i+1) == ')'){
                        sb.append("o");
                        i++;
                  } else{
                        sb.append("al");
                        i=i+3;
                  }
            }
          return sb.toString();
      }
      public static void main(String[] args) {
            System.out.println(interpret("G()(al)"));
      }
}
