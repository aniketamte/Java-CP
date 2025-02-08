public class sqRoot {
      //Square Root of Integer
      public static int sqrt(int A) {
        if (A == 0 || A == 1) {
            return A; // Base cases
        }
        int low = 1, high = A, ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long square = (long) mid * mid;

            if (square == A) {
                return mid; // Perfect square case
            } else if (square < A) {
                ans = mid; // Store the last valid mid
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }

        return ans; // Floor of sqrt(A)
    }
    public static void main(String[] args) {
      int A =11;
      System.out.println(sqrt(A));
    }
}
