public class main {
      public static void chanArr(int[] arr, int i, int value) {
            // base case
            if (i == arr.length) {
                  printArr(arr);
                  return;
            }
            // recursion
            arr[i] = value;
            chanArr(arr, i + 1, value + 1);
            arr[i] = arr[i] - 2;
      }

      public static void printArr(int arr[]) {
            for (int i = 0; i < arr.length; i++) {
                  System.out.print(arr[i] + " ");
            }
            System.out.println();
      }

      public static void main(String[] args) {
            int arr[] = new int[5];
            chanArr(arr, 0, 1);
            printArr(arr);
      }
}
