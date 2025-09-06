import java.util.Arrays;
public class check{
      public static void checkAndReverse(int[] arr){
            int n = arr.length;

            int firstHalf = 0;
            int secondHalf = 0;
            for(int i=0; i<n/2; i++){
                  firstHalf += arr[i];
            }
            for(int i=n/2; i<n; i++){
                  secondHalf += arr[i];
            }
            if(firstHalf < secondHalf){
                  for(int i=0, j=n-1; i<j; i++, j--){
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                  }
            }
            System.out.println(Arrays.toString(arr));
      }
      public static void main(String[] args) {
            int arr[] = {1, 2, 3, 10, 20, 30};
            checkAndReverse(arr);
      }
}