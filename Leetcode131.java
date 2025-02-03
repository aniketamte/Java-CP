
import java.util.*;

public class Leetcode131 {

      // Palindrome Partitioning : 131

    public static boolean isPalindrom(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void getAllParts(String s, List<String> partitions, List<List<String>> ans, int start) {

        if (s.length() == start) {
            ans.add(new ArrayList<>(partitions));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String part = s.substring(start, i + 1);

            if (isPalindrom(part)) {
                partitions.add(part);
                getAllParts(s, partitions, ans, i + 1);
                partitions.remove(partitions.size() - 1);
            }
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> partitions = new ArrayList<>();

        getAllParts(s, new ArrayList<>(), ans, 0);
        return ans;
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }
}
