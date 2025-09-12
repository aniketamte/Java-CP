
import java.util.*;

public class Q3_Anagram {

    static boolean isAnagram(String s1, String s2) {
        char[] a = s1.replaceAll("\\s", "").toLowerCase().toCharArray();
        char[] b = s2.replaceAll("\\s", "").toLowerCase().toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine(), s2 = sc.nextLine();
        System.out.println(isAnagram(s1, s2) ? "Anagram" : "Not Anagram");
    }
}
