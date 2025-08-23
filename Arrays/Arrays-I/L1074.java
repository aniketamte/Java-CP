
public class L1074 {

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

    public static void main(String[] args) {
        int matrix[][] = {
            {0, 1, 0},
            {1, 1, 1},
            {0, 1, 0}
        };
        int target = 0;
        System.out.println(numSubmatrixSumTarget(matrix, target));
    }
}
