import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode638 {
      public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<List<Integer>, Integer> memo = new HashMap<>();
        return shopping(price, special, needs, memo);
    }

    private static int shopping(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> memo) {
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }

        // Calculate the direct cost without any special offers
        int minCost = dot(needs, price);

        // Try every special offer
        for (List<Integer> offer : special) {
            List<Integer> newNeeds = new ArrayList<>(needs);
            boolean valid = true;

            for (int i = 0; i < needs.size(); i++) {
                int diff = newNeeds.get(i) - offer.get(i);
                if (diff < 0) { // Cannot use this offer
                    valid = false;
                    break;
                }
                newNeeds.set(i, diff);
            }

            // If the offer is valid, recursively calculate the cost
            if (valid) {
                minCost = Math.min(minCost, offer.get(needs.size()) + shopping(price, special, newNeeds, memo));
            }
        }

        // Cache the result for current needs
        memo.put(needs, minCost);
        return minCost;
    }

    private static int dot(List<Integer> a, List<Integer> b) {
        int sum = 0;
        for (int i = 0; i < a.size(); i++) {
            sum += a.get(i) * b.get(i);
        }
        return sum;
    }
    public static void main(String[] args) {
      int price[] = {2,5};
      int special[][] ={
            {3,0,5},
            {1,2,10}
      };
      int needs[] = {3,2};
      System.out.println(shoppingOffers(price, special, needs));
    }
}
