public class Leetcode1859 {
    public static String sortSentence(String s) {
      String words[] = s.split(" ");
      String cache[] = new String[words.length];

      for(String word : words){
            int index = word.charAt(word.length()-1) - '1';
            cache[index] = word.substring(0, word.length()-1);
      }
        return String.join(" ", cache);
    }  

    public static void main(String[] args) {
      String s = "is2 sentence4 This1 a3";
        Leetcode1859 sol = new Leetcode1859();
        String res = sol.sortSentence(s);
        System.out.println("Sorted Sentence : " + res);

    }
}
