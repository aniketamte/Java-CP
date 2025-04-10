
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode1773 {

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;

        for (int i = 0; i < items.size(); i++) {
            if (ruleKey.equals("type") && items.get(i).get(0).equals(ruleValue)) {
                res++;
            }
            if (ruleKey.equals("color") && items.get(i).get(1).equals(ruleValue)) {
                res++;
            }
            if (ruleKey.equals("name") && items.get(i).get(2).equals(ruleValue)) {
                res++;
            }
        }

        return res;

    }

    public static void main(String[] args) {
        // Sample data
        List<List<String>> items = new ArrayList<>();
        items.add(Arrays.asList("phone", "blue", "pixel"));
        items.add(Arrays.asList("computer", "silver", "lenovo"));
        items.add(Arrays.asList("phone", "gold", "iphone"));

        // Rule
        String ruleKey = "type";
        String ruleValue = "phone";

        // Create Solution instance and call the method
        Solution sol = new Solution();
        int result = Leetcode1773.countMatches(items, ruleKey, ruleValue);


        // Output the result
        System.out.println("Matching items count: " + result);
    }

}
