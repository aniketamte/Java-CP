
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class contest434Q2 {

      //Leetcode Weekly contest 434
      //Question 2 ----> Count Mentions Per User

    public static int[] calculateMentions(int numberOfUsers, List<List<String>> events) {
        int[] mentions = new int[numberOfUsers];
        boolean[] isOnline = new boolean[numberOfUsers];
        Arrays.fill(isOnline, true);

        TreeMap<Integer, List<List<String>>> eventMap = new TreeMap<>();
        for (List<String> event : events) {
            int timestamp = Integer.parseInt(event.get(1));
            eventMap.putIfAbsent(timestamp, new ArrayList<>());
            eventMap.get(timestamp).add(event);
        }
        Map<Integer, Integer> offlineUntil = new HashMap<>();

        for (Map.Entry<Integer, List<List<String>>> entry : eventMap.entrySet()) {
            int currentTime = entry.getKey();
            List<List<String>> currentEvents = entry.getValue();

            for (Map.Entry<Integer, Integer> offlineEntry : offlineUntil.entrySet()) {
                if (offlineEntry.getValue() <= currentTime) {
                    isOnline[offlineEntry.getKey()] = true;
                }
            }
            offlineUntil.entrySet().removeIf(e -> e.getValue() <= currentTime);

            for (List<String> event : currentEvents) {
                String eventType = event.get(0);
                if (eventType.equals("OFFLINE")) {
                    int userId = Integer.parseInt(event.get(2));
                    isOnline[userId] = false;
                    offlineUntil.put(userId, currentTime + 60);
                } else if (eventType.equals("MESSAGE")) {
                    String mentionsString = event.get(2);
                    if (mentionsString.equals("ALL")) {
                        for (int i = 0; i < numberOfUsers; i++) {
                            mentions[i]++;
                        }
                    } else if (mentionsString.equals("HERE")) {
                        for (int i = 0; i < numberOfUsers; i++) {
                            if (isOnline[i]) {
                                mentions[i]++;
                            }
                        }
                    } else {
                        String[] mentionedIds = mentionsString.split(" ");
                        for (String id : mentionedIds) {
                            if (id.startsWith("id")) {
                                int userId = Integer.parseInt(id.substring(2));
                                mentions[userId]++;
                            }
                        }
                    }
                }
            }
        }

        return mentions;
    }

    public static void main(String[] args) {
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
