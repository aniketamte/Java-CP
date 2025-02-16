
public class Leetcode48 {
      //Leetcode : 48 ---> Rotate Image
      //Striver SDE Sheet

    public static void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }

    public static void transpose(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= i; j++) {
                int temp = matrix[i][j];
                //row=col
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void reverse(int matrix[][]) {
        //Left pointer Approach
        for (int i = 0; i < matrix.length; i++) {
            int left = 0;
            int right = matrix.length - 1;

            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void printArr(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int matrix[][] = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        rotate(matrix);
        printArr(matrix);
    }
}
