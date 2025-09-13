public class MaxBulbsBrute{
      public static int maxBulbs(int[] arr){
            int n = arr.length;
            int max = 0;
            for(int i=0; i<n; i++){
                  int min = arr[i];
                  for(int j=i; j<n; j++){
                        if(arr[j] < min){
                              min = arr[j];
                        }
                        int bulbs = (j-i+1) * min;
                        if(bulbs > max){
                              max = bulbs;
                        }
                  }
            }
            return max;
      }
      public static void main(String[] args) {
          int[] arr = {5, 8, 9, 10};
          System.out.println(maxBulbs(arr));
      }
}