
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode120 {

    public static int minimumTotal(List<List<Integer>> triangle) {
        return solve(triangle, 0, 0);
    }

    public static int solve(List<List<Integer>> triangle, int row, int col) {
        int n = triangle.size();
        if (row == n - 1) {
            return triangle.get(row).get(col);
        }
        int down = solve(triangle, row + 1, col);
        int diagonal = solve(triangle, row + 1, col + 1);

        return triangle.get(row).get(col) + Math.min(down, diagonal);
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        int result = minimumTotal(triangle);
        System.out.println("Minimum Path Sum = " + result);  // Expected: 11
    }
}
