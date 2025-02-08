public class peakElement{
      //Interview Bit Question
      //Find a peak element
      public static int solve(int[] A) {
        int l = 0;
        int r = A.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (A[mid] > A[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return A[l];
    }
    public static void main(String[] args) {
      int A[] = {5, 17, 100, 11};
      System.out.println(solve(A));
    }
}