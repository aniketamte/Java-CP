public class Leetcode3339 {
      public static int possibleStringCount(String word){
            int count = 0;
            for(int i=1; i<word.length(); i++){
                  if(word.charAt(i) == word.charAt(i-1)){
                        count++;
                  }
            }
            return count + 1;
      }
      public static void main(String[] args) {
            String word = "abbcccc";
            System.out.println(possibleStringCount(word));
      }
}
