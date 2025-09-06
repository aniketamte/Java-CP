public class CountValidSubarray {
      public static int countValidSubarrays(int[] arr, int n) {
        int count = 0;

        // Traverse through all possible subarrays of size 3
        for (int i = 0; i <= n - 3; i++) {
            int first = arr[i];
            int second = arr[i + 1];
            int third = arr[i + 2];

            if (first + third == second) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 5, 2, 4, 2};
        int n = arr.length;

        System.out.println(countValidSubarrays(arr, n));
    }
}
