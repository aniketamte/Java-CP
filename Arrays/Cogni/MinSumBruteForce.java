import java.util.*;
public class MinSumBruteForce {
      public static void main(String[] args) {
            int A[] = {4,1,6};
            int B[] = {3,1,2};
            Arrays.sort(A);
            Arrays.sort(B);

            for(int i=0, j=B.length-1; i<j; i++, j--){
                  int temp = B[i];
                  B[i] = B[j];
                  B[j] = temp;
            }

            int sum = 0;
            for(int i=0; i<A.length; i++){
                  sum += A[i] * B[i];
            }
            System.out.println(sum);
      }
}
