public class Leetcode28 {
      public static int strStr(String haystack, String needle) {
            for(int i=0; i<haystack.length(); i++){
                  for(int j=0; j<needle.length(); j++){
                        if(haystack.charAt(i + j) != needle.charAt(j)) {
                              break;
                        }
                        if(j == needle.length() - 1) {
                              return i; // Found the needle
                        }
                  }
            }
            return -1; // Needle not found
      }
      public static void main(String[] args) {
            String haystack = "hello";
            String needle = "ll"; // Example input
            int result = strStr(haystack, needle);
            System.out.println("The index of the first occurrence of '" + needle + "' in '" + haystack + "' is: " + result);
      }
}
