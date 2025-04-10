
public class BookAlloc {
    //26-03-2025
    //Book Allocation or Allocate Books Problem
    //Solve using Binary Search

    public static boolean isValid(int arr[], int n, int m, int maxAllowedPages) {
        int student = 1, pages = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] > maxAllowedPages) {
                return false;
            }

            if (pages + arr[i] <= maxAllowedPages) {
                pages += arr[i];
            } else {
                student++;
                pages = arr[i];
            }
        }
        return student > m ? false : true;
    }

    public static int allocateBook(int arr[], int n, int m) {
        if (m > n) {
            return -1;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        int ans = -1;
        int start = 0;
        int end = sum;   //Range of possible ans form 0 to sum

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isValid(arr, n, m, mid)) {
                //left
                ans = mid;
                end = mid - 1;
            } else {
                //right
                start = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {15, 17, 20};
        int n = 3, m = 2;
        //n---->books
        //m---->student
        //arr-->Pages

        System.err.println(allocateBook(arr, n, m));
    }
}
