public class Leetcode921 {
      public static int minAddToMakeValid(String s) {
            int size = 0;
            int open = 0;
            for(char c : s.toCharArray()){
                  if(c == '('){
                        size++;
                  } else if(size > 0) {
                        size--;
                  } else {
                        open++;
                  }
            }
            return size + open;
      }
      public static void main(String[] args) {
            String s = "())";
            System.out.println(minAddToMakeValid(s)); // Output: 1
      }
}
