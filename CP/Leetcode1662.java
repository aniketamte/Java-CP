public class Leetcode1662 {
     public static boolean arrayStringsAreEqual(String[] word1, String[] word2){
      return (String.join("", word1)).equals(String.join("", word2));
     } 
     public static void main(String[] args) {
      String word1[] = {"ab", "c"};
      String word2[] = {"a", "bc"};

      System.out.println(arrayStringsAreEqual(word1, word2));
     }
}
