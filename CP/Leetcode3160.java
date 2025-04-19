
import java.util.*;

public class Leetcode3160 {

      //Find the Number of Distinct Colors Among the Balls

      //POTD ---> 07/02/2025

    public static int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> node = new HashMap<>();
        Map<Integer, Integer> color = new HashMap<>();
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], y = queries[i][1];

            if (node.containsKey(x)) {
                int prevColor = node.get(x);
                if (prevColor == y) {
                    ans[i] = color.size();
                    continue;
                }
                if (color.get(prevColor) == 1) {
                    color.remove(prevColor);
                } else {
                    color.put(prevColor, color.get(prevColor) - 1);
                }
            }

            node.put(x, y);
            color.put(y, color.getOrDefault(y, 0) + 1);
            ans[i] = color.size();
        }

        return ans;
    }

    public static void printArr(int queries[][]) {
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < queries[0].length; j++) {
                System.out.print(queries[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int limit = 4;
        int queries[][] = {
            {1, 4},
            {2, 5},
            {1, 3},
            {3, 4}
        };
        System.out.println(queryResults(limit, queries));
        printArr(queries);
    }
}
