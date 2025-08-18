
import java.util.ArrayList;
import java.util.List;

public class Leetcode679 {

    private static final double EPSILON = 0.1;

    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int card : cards) {
            nums.add((double) card);
        }
        return solve(nums);
    }

    private boolean solve(List<Double> cards) {
        if (cards.size() == 1) {
            return Math.abs(cards.get(0) - 24) <= EPSILON;
        }

        for (int i = 0; i < cards.size(); i++) {
            for (int j = 0; j < cards.size(); j++) {
                if (i == j) {
                    continue;
                }

                List<Double> temp = new ArrayList<>();
                for (int k = 0; k < cards.size(); k++) {
                    if (k != i && k != j) {
                        temp.add(cards.get(k));
                    }
                }

                double a = cards.get(i);
                double b = cards.get(j);
                List<Double> possibleVals = new ArrayList<>();
                possibleVals.add(a + b);
                possibleVals.add(a - b);
                possibleVals.add(b - a);
                possibleVals.add(a * b);

                if (Math.abs(b) > 0.0) {
                    possibleVals.add(a / b);
                }
                if (Math.abs(a) > 0.0) {
                    possibleVals.add(b / a);
                }

                for (double val : possibleVals) {
                    temp.add(val);
                    if (solve(temp)) {
                        return true;
                    }
                    temp.remove(temp.size() - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Leetcode679 solver = new Leetcode679();
        int[] cards1 = {4, 1, 8, 7};
        System.out.println(solver.judgePoint24(cards1)); // true

        int[] cards2 = {1, 2, 1, 2};
        System.out.println(solver.judgePoint24(cards2)); // false
    }
}
