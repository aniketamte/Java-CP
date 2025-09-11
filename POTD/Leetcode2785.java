import java.util.*;
public class Leetcode2785 {
    public static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }

    public static String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                vowels.add(ch);
            }
        }
        Collections.sort(vowels);
        int j = 0;
        // Replace vowels in order
        char[] result = s.toCharArray();
        for (int i = 0; i < result.length; i++) {
            if (isVowel(result[i])) {
                result[i] = vowels.get(j++);
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        String s = "lEetcOde";
        System.out.println(sortVowels(s));
    }
}
