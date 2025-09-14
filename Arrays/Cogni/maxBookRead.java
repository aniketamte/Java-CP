import java.util.*;
public class maxBookRead{
      public static int maxBook(int A[], int N){
            Arrays.sort(A);
            int totaltime = 0;
            int count = 0;
            for(int time : A){
                  if(totaltime + time <= N){
                      totaltime += time;
                      count++;
                  }
            }
            return count;
      }
      public static void main(String[] args) {
          int A[] = {5, 3, 2, 8};
          int N = 10;
          System.out.println(maxBook(A, N));
      }
}