import java.util.Arrays;

public class Leetcode48 {
      public static void rotate(int[][] matrix) {
            transpose(matrix);
            reverse(matrix);
      }

      public static void transpose(int matrix[][]){
            int n = matrix.length;
            for(int i=0; i<n; i++){
                  for(int j=0; j<=i; j++){
                        int temp = matrix[i][j];
                        matrix[i][j] = matrix[j][i];
                        matrix[j][i] = temp;
                  }
            }
      }

      public static void reverse(int matrix[][]){
            for(int i=0; i<matrix.length; i++){
                  int left = 0;
                  int right = matrix.length - 1;

                  while(left < right){
                        int temp = matrix[i][left];
                        matrix[i][left] = matrix[i][right];
                        matrix[i][right] = temp;
                        left++;
                        right--;
                  }
            }
      }
      public static void main(String[] args) {
            int matrix[][] = {
                  {1, 2, 3},
                  {4, 5, 6},
                  {7, 8, 9}
            };
            Leetcode48 sol = new Leetcode48();
            sol.rotate(matrix);
            System.out.println(Arrays.deepToString(matrix));
      }
}
