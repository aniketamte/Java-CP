
import java.util.Scanner;

public class MaxLevel{
      public static int maxLevel(int N){
            StringBuilder res = new StringBuilder();
            while(N > 0){
                  int power = 1;
                  while(power * 2 <= N){
                        power *= 2;
                  }
                  res.append(power);
                  N-=power;
            }
            return Integer.parseInt(res.toString());
      }
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

          // number of test cases
          int T = sc.nextInt();

          while (T-- > 0) {
              int N = sc.nextInt();
              System.out.println(maxLevel(N));
          }
      }
}