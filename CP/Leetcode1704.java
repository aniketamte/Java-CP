public class Leetcode1704 {
      public static boolean halvesAreAlike(String s) {
        int n = s.length();
        int count1 = 0, count2 = 0;
        String vowels = "aeiouAEIOU";

        for (int i = 0; i < n / 2; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                count1++;
            }
        }

        for (int i = n / 2; i < n; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                count2++;
            }
        }

        return count1 == count2;

    }

    public static void main(String[] args) {
        // Test cases
        String s1 = "book";
        String s2 = "textbook";

        System.out.println("Input: " + s1 + " → Output: " + halvesAreAlike(s1));       // true
        System.out.println("Input: " + s2 + " → Output: " + halvesAreAlike(s2));       // false
    }
}
