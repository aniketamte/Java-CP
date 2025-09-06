import java.util.*;
public class convertToPermutation{
      public static int minOpn(int N, int A[]){
            Arrays.sort(A);
            int operation = 0;
            for(int i=0; i<N; i++){
                  if(A[i] < i+1){
                        operation += Math.abs(A[i] - (i+1));
                  }
            }
            return operation;
      }
      public static void main(String[] args) {
            int N = 5;
            int A[] = {1, 1, 3, 3, 4};
            System.out.println(minOpn(N, A));
      }
}