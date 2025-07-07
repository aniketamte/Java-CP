
import java.util.Arrays;

/*
  Question1:Apply Merge sort to sort an array of Strings.(Assume that all the characters in all the Strings are in lowercase). (EASY)
  
  Sample Input 1: arr = { "sun", "earth", "mars", "mercury"}
  
  Sample Output 1: arr = { "earth", "mars", "mercury","sun"}
 */
public class Ques1 {
      public static void mergeSort(String arr[], int left, int right){
            if(left < right){
                  int mid = (left + right) / 2;
                  mergeSort(arr, left, mid);
                  mergeSort(arr, mid + 1, right);
                  merge(arr, left, mid, right);
            }
      }
      public static void merge(String arr[], int left, int mid, int right){
            //Size of left and right subarrays
            int n1 = mid - left + 1;
            int n2 = right - mid;
            String leftArr[] = new String[n1];
            String rightArr[] = new String[n2];
            for(int i = 0; i < n1; i++){
                  leftArr[i] = arr[left + i];
            }
            for(int j = 0; j < n2; j++){
                  rightArr[j] = arr[mid + 1 + j];
            }
            int i = 0, j = 0, k = left;
            while(i<n1 && j<n2){
                  if(leftArr[i].compareTo(rightArr[j]) <= 0){
                        arr[k] = leftArr[i];
                        i++;
                  } else{
                        arr[k] = rightArr[j];
                        j++;
                  }
                  k++;
            }
            while(i < n1){
                  arr[k] = leftArr[i];
                  i++;
                  k++;
            }
            while(j < n2){
                  arr[k] = rightArr[j];
                  j++;
                  k++;
            }
      }
      public static void main(String[] args) {
            String arr[] = {"sun", "earth", "mars", "mercury"};
            int n = arr.length;
            mergeSort(arr, 0, n - 1);
            System.out.println("Sorted Array : " + Arrays.toString(arr));
      }
}
