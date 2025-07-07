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
     public static void main(String[] args) {
            int arr[] = {6,3,9,5,2,8};
            mergeSort(arr, 0, arr.length-1);
            printArr(arr);
      }
}
