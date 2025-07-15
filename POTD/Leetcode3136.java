public class Leetcode3136 {
      public static boolean isValid(String word) {
            if (word.length() < 3) {
                  return false;
            }
            boolean hasVowel = false;
            boolean hasConsonant = false;

            for (char ch : word.toCharArray()) {
                  if (Character.isLetter(ch)) {
                        ch = Character.toLowerCase(ch);
                        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                              hasVowel = true;
                        } else {
                              hasConsonant = true;
                        }
                  } else if (!Character.isDigit(ch)) {
                        return false;
                  }
            }
            return hasVowel && hasConsonant;
      }

      public static void main(String[] args) {
            System.out.println(isValid("234Adas")); 
            System.out.println(isValid("a3$e"));
      }
}
