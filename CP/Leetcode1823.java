
import java.util.*;

public class Leetcode1823 {
    //6Company 30Days Challenge -----> Day1
    //Who wiil win ----> Leetcode 1823

    public static int findTheWinner(int n, int k) {
        // Initialize list of N friends, labeled from 1-N
        List<Integer> circle = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            circle.add(i);
        }

        // Maintain the index of the friend to start the count on
        int startIndex = 0;

        // Perform eliminations while there is more than 1 friend left
        while (circle.size() > 1) {
            // Calculate the index of the friend to be removed
            int removalIndex = (startIndex + k - 1) % circle.size();

            // Erase the friend at removalIndex
            circle.remove(removalIndex);

            // Update startIndex for the next round
            startIndex = removalIndex;
        }

        // Return the only remaining friend
        return circle.get(0); // Corrected to use get(0)
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 2;
        System.out.println(findTheWinner(n, k)); // Output the winner
    }
}
