
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode3442 {

    public static int maxDifference(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        // Count frequencies of each character
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        List<Integer> evenFreq = new ArrayList<>();
        List<Integer> oddFreq = new ArrayList<>();

        // Separate frequencies into even and odd lists
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                evenFreq.add(entry.getValue());
            } else {
                oddFreq.add(entry.getValue());
            }
        }

        // Edge case: If no odd or even frequencies exist, return -1
        if (oddFreq.isEmpty() || evenFreq.isEmpty()) {
            return -1;
        }

        int maxOdd = Collections.max(oddFreq);
        int minEven = Collections.min(evenFreq);

        return maxOdd - minEven;
    }

    public static void main(String[] args) {
        String s = "abcabcab";
        System.out.println(maxDifference(s));
    }
}
