public class painterProblem {
      public static boolean isPossible(int arr[], int n, int m, int maxAllowedTime){   //O(n)
            int painters =1, time =0;

            for(int i=0; i<n; i++){
                  if(time + arr[i] <= maxAllowedTime){
                        time += arr[i];
                  } else{
                        painters++;
                        time = arr[i];
                  }
            }
            return painters<=m;
      }
      public static int minTimeTopaint(int arr[], int n, int m){ //O(log(sum) * n)
            int sum =0, maxval = Integer.MIN_VALUE;

            for(int i=0; i<n; i++){  //O(n)
                  sum += arr[i];
                  maxval = Math.max(maxval, arr[i]);
            }

            int start = maxval, end = sum, ans=-1;

            while(start<=end){  //O(log(sum) * n)
                  int mid = start + (end-start)/2;

                  if(isPossible(arr, n, m, mid)){
                        //left
                        ans=mid;
                        end=mid-1;
                  } else{
                        //right
                        start=mid+1;
                  }
            }
            return ans;
      }
      public static void main(String[] args) {
            int arr[] = {40, 30, 10, 20};
            int n=4, m=2;

            System.out.println(minTimeTopaint(arr, n, m));
      }
}
