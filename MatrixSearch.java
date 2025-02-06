public class MatrixSearch {
      public static int searchMatrix(int[][] A, int B) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == B) {
                    return 1;
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
      int A[][] = {
            {1,3,5,7},
            {10,11,16,20},
            {23, 30, 34, 50}
      };
      int B = 3;
      System.out.println(searchMatrix(A, B));
    }
}
