public class LinearSearch {
      public static int linearSearch(int arr[], int num){
            for(int i=0; i<arr.length; i++){
                  if(arr[i] == num){
                        return i;
                  }
            }
            return -1;
      }
      public static void main(String[] args) {
            int arr[] = {1, 2, 3, 4, 5};
            int num = 3;
            System.out.println(linearSearch(arr, num));
      }
}
