import java.util.*;

public class Leetcode3 {
    //Longest Substring Without Repeating Characters

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;         
        }
        int maxans = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) // outer loop for traversing the string
        {
            Set< Character> se = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (se.contains(s.charAt(j))) {
                    maxans = Math.max(maxans, j - i);
                    break;
                }
                se.add(s.charAt(j));
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
