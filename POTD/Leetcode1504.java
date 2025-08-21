public class Leetcode1504 {
    public static int oneDArrayCount(int rowMask[]) {
        int consecutiveOnes = 0;
        int subarrayCount = 0;

        for (int val : rowMask) {
            if (val == 0) {
                consecutiveOnes = 0;
            } else {
                consecutiveOnes++;
            }
            subarrayCount += consecutiveOnes;
        }

        return subarrayCount;
    }

    public static int numSubmat(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int totalCount = 0;
        for (int topRow = 0; topRow < rows; topRow++) {
            int[] rowMask = new int[cols];
            for (int i = 0; i < cols; i++) {
                rowMask[i] = 1;
            }
            for (int bottomRow = topRow; bottomRow < rows; bottomRow++) {
                for (int col = 0; col < cols; col++) {
                    rowMask[col] = rowMask[col] & mat[bottomRow][col];
                }
                totalCount += oneDArrayCount(rowMask);
            }
        }

        return totalCount;
    }

    public static void main(String[] args) {
        int mat[][] = {
            {1, 0, 1},
            {1, 1, 0},
            {1, 1, 0}
        };
        System.out.println(numSubmat(mat));
    }
}
