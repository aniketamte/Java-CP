
import java.util.Arrays;

public class AgressiveCows {

      //Aggressive Cows Problem 
      //13-03-2025

    public static boolean isPossible(int arr[], int N, int C, int minAllowedDist) { //O(N)
        int cows = 1, lastStallPos = arr[0];

        for (int i = 1; i < N; i++) {
            if (arr[i] - lastStallPos >= minAllowedDist) {
                cows++;
                lastStallPos = arr[i];
            }

            if (cows == C) {
                return true;
            }
        }
        return false;
    }

    public static int getDistance(int arr[], int N, int C) {  //NlogN
        Arrays.sort(arr);
        int start = 1;
        int end = arr[N - 1] - arr[0];
        int ans = -1;

        while (start <= end) { //O(log(range) * N)
            int mid = start + (end - start) / 2;

            if (isPossible(arr, N, C, mid)) {
                //right
                ans = mid;
                start = mid + 1;
            } else {
                //left
                end = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int N = 5, C = 3;
        int arr[] = {1, 2, 8, 4, 9};
        System.out.println(getDistance(arr, N, C));
    }
}
