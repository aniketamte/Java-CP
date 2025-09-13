import java.util.*;
public class Sort{
      static void bubbleSort(int arr[]){
            int n = arr.length;
            for(int turn = 0; turn < n-1; turn++){
                  for(int j=0; j<n-1-turn; j++){
                        if(arr[j] > arr[j+1]){
                              int temp = arr[j];
                              arr[j] = arr[j+1];
                              arr[j+1] = temp;
                        }
                  }
            }
      }

      public static void printArr(int arr[]){
            for(int i=0; i<arr.length; i++){
                  System.err.print(arr[i] + " ");
            }
            System.out.println();
      }

      static int getSecondLargest(int[] arr){
            int n = arr.length;
            Arrays.sort(arr);
            for(int j=n-2; j>0; j--){
                  if(arr[j] != arr[j+1]){
                        return arr[j];
                  }
            }
            return -1;
      }

      static int maxConsecBits(int[] arr){
            int n = arr.length;
            int maxCount = 0;
            int count = 1;
            for(int i=1; i<n; i++){
                  if(arr[i] == arr[i-1]){
                        count++;
                        maxCount = Math.max(count, maxCount);
                  } else{
                        count = 1;
                  }
            }
            return count;
      }

      static void pushZerosToEnd(int[] arr){
            int count = 0;
            for(int i=0; i<arr.length; i++){
                  if(arr[i] != 0){
                        int temp = arr[i];
                        arr[i] = arr[count];
                        arr[count] = temp;
                  }
            }
            count++;
      }
      static int removeDuplicates(int[] arr) {
            HashSet<Integer> s = new HashSet<>();
            int idx = 0;
            for(int i=0; i<arr.length; i++){
                  if(!s.contains(arr[i])){
                        s.add(arr[i]);
                        arr[idx++] = arr[i];
                  }
            }
            return idx;
      }
      public static void main(String[] args) {
            // int arr[] = {4,3,2,1,6,5};
            // bubbleSort(arr);
            // printArr(arr);
            // System.out.println(getSecondLargest(arr));

            int arr[] = {0, 1, 0, 1, 1, 1, 1};
            System.out.println(maxConsecBits(arr));
            pushZerosToEnd(arr);
            for(int num : arr){
                  System.out.print(num);
            }
            System.out.println();
            System.out.println(removeDuplicates(arr));
      }
}