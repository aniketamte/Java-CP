
import java.util.Arrays;

public class AbsoluteDifferencePair {
    //Minimum Absolute Difference Pair ===> Greedy Algorithm
    //15-03-2025 
    //Revision

    public static void main(String[] args) {
      //   int A[] = {1, 2, 3};
      //   int B[] = {2, 1, 3};

        int A[] = {4,1,8,7};
        int B[] = {2,3,6,5};

        Arrays.sort(A);
        Arrays.sort(B);

        int minDiff = 0;

        for (int i = 0; i < A.length; i++) {
            minDiff += Math.abs(A[i] - B[i]);
        }
        System.out.println("Minimum Absolute Difference of pair = " + minDiff);
    }
}
