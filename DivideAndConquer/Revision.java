public class Revision {
      public static void printArr(int arr[]){
            for(int i=0; i<arr.length; i++){
                  System.out.print(arr[i] + " ");
            }
            System.out.println();
      }

      public static void mergeSort(int arr[], int si, int ei){
            if(si >= ei){
                  return;
            }
            int mid = (si + ei) / 2;
            mergeSort(arr, si, mid);
            mergeSort(arr, mid+1, ei);
            merge(arr, si, mid, ei);
      }

      public static void merge(int arr[], int si, int mid, int ei){
            int temp[] = new int[ei-si+1];
            int i=si; //Idx for first sorted part(left part)
            int j=mid+1; //Idx for second sorted part(right part)
            int k=0; //Idx for temp array

            while(i<= mid && j<= ei){
                  if(arr[i] <= arr[j]){
                        temp[k++] = arr[i++];
                  } else{
                        temp[k++] = arr[j++];
                  }
            }

            //copy remaining elements of left part
            while(i<=mid){
                  temp[k++] = arr[i++]; 
            }

            //copy remaining elements of right part
            while(j<=ei){
                  temp[k++] = arr[j++];
            }

            //copy elements from temp array to original array
            for(k=0, i=si; k<temp.length; k++, i++){
                  arr[i] = temp[k];
            }
      }

      public static void quickSort(int arr[], int si, int ei){
            //Base Case
            if(si >= ei){
                  return;
            }

            //Last element as pivot
            int pIdx = partition(arr, si, ei);
            quickSort(arr, si, pIdx-1); //Left 
            quickSort(arr, pIdx+1, ei); //Right
      }

      public static int partition(int arr[], int si, int ei){
            int pivot = arr[ei]; //Last element as pivot
            int i = si-1; //Idx for smaller elements
            for(int j=si; j<ei; j++){
                  if(arr[j] <= pivot){
                        i++;
                        int temp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = temp;
                  }
            }
            i++;
            int temp = pivot;
            arr[ei] = arr[i];
            arr[i] = temp;
            return i;
      }

     public static void main(String[] args) {
            int arr[] = {6,3,9,5,2,8};
            mergeSort(arr, 0, arr.length-1);
            printArr(arr);
            System.out.println("Using Quick sort");
            quickSort(arr, 0, arr.length-1);
            printArr(arr);
      }
}
