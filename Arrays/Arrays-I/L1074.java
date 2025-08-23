
import java.util.HashMap;
import java.util.Map;

public class L1074 {
    //Brute Force

    public static int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;

        for (int startRow = 0; startRow < m; startRow++) {
            for (int startCol = 0; startCol < n; startCol++) {
                for (int endRow = startRow; endRow < m; endRow++) {
                    for (int endCol = startCol; endCol < n; endCol++) {
                        int sum = 0;
                        for (int i = startRow; i <= endRow; i++) {
                            for (int j = startCol; j <= endCol; j++) {
                                sum += matrix[i][j];
                            }
                        }
                        if (sum == target) {
                            result++;
                        }
                    }
                }
            }
        }

        return result;
    }

    public static int numSubmatrixSumTarget2(int[][] matrix, int target) {
        int rows = matrix.length; // m
        int cols = matrix[0].length; // n

        // First take the cumulative sum row-wise
        for (int row = 0; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                matrix[row][col] += matrix[row][col - 1];
            }
        }

        // Now, find the "No. of subarrays with sum k" in the downward direction
        int result = 0;
        for (int startCol = 0; startCol < cols; startCol++) {
            for (int currCol = startCol; currCol < cols; currCol++) {
                // We need to find all submatrices sum

                // Now comes the concept of "No. of subarrays with sum k"
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int sum = 0;

                // Go downwards row-wise
                for (int row = 0; row < rows; row++) {
                    sum += matrix[row][currCol] - (startCol > 0 ? matrix[row][startCol - 1] : 0);

                    if (map.containsKey(sum - target)) {
                        result += map.get(sum - target);
                    }

                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int matrix[][] = {
            {0, 1, 0},
            {1, 1, 1},
            {0, 1, 0}
        };
        int target = 0;
        System.out.println(numSubmatrixSumTarget(matrix, target));
        System.out.println(numSubmatrixSumTarget2(matrix, target));
    }
}
