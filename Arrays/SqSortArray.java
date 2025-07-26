public class SqSortArray {
      public static int[] sortArray(int arr[]){
            int n = arr.length;
            int result[] = new int[n];
            int left = 0, right = n - 1;
            int pos = n-1;
            while (left <= right){
                  int leftSquare = arr[left] * arr[left];
                  int rightSquare = arr[right] * arr[right];
                  if (leftSquare > rightSquare){
                        result[pos--] = leftSquare;
                        left++;
                  } else {
                        result[pos--] = rightSquare;
                        right--;
                  }
            }
            return result;
      }
      public static void main(String[] args) {
            int arr[] = {-4, -1, 0, 3, 10};
            int sortedArray[] = sortArray(arr);
            for (int num : sortedArray) {
                  System.out.print(num + " ");
            }
      }
}
