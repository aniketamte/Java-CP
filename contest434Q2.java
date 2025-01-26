import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class contest434Q2 {
      public static int[] calculateMentions(int numberOfUsers, List<List<String>> events){
            int[] mentions = new int[numberOfUsers];
          boolean[] isOnline = new boolean[numberOfUsers];
          Arrays.fill(isOnline, true);

           TreeMap<Integer, List<List<String>>> eventMap = new TreeMap<>();
        for (List<String> event : events) {
            int timestamp = Integer.parseInt(event.get(1));
            eventMap.putIfAbsent(timestamp, new ArrayList<>());
            eventMap.get(timestamp).add(event);
        }
      }
      public static void main(String[] args){
            // Example 1
        int numberOfUsers1 = 2;
        List<List<String>> events1 = Arrays.asList(
            Arrays.asList("MESSAGE", "10", "id1 id0"),
            Arrays.asList("OFFLINE", "11", "0"),
            Arrays.asList("MESSAGE", "71", "HERE")
        );
        System.out.println(Arrays.toString(calculateMentions(numberOfUsers1, events1))); // Output: [2, 2]

        // Example 2
        int numberOfUsers2 = 2;
        List<List<String>> events2 = Arrays.asList(
            Arrays.asList("MESSAGE", "10", "id1 id0"),
            Arrays.asList("OFFLINE", "11", "0"),
            Arrays.asList("MESSAGE", "12", "ALL")
        );
        System.out.println(Arrays.toString(calculateMentions(numberOfUsers2, events2))); // Output: [2, 2]

        // Example 3
        int numberOfUsers3 = 2;
        List<List<String>> events3 = Arrays.asList(
            Arrays.asList("OFFLINE", "10", "0"),
            Arrays.asList("MESSAGE", "12", "HERE")
        );
        System.out.println(Arrays.toString(calculateMentions(numberOfUsers3, events3))); // Output: [0, 1]
      }
}
