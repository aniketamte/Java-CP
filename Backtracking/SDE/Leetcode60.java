import java.util.*;
public class Leetcode60 {
      public static String getPermutation(int n, int k) {
            int fact = 1;
            List<Integer> number = new ArrayList<>();
            for (int i = 1; i < n; i++){
                  fact *= i;
                  number.add(i);
            }
            number.add(n);
            String ans = "";
            k = k-1;
            while(true){
                  ans = ans + number.get(k/fact);
                  number.remove(k/fact);
                  if(number.size() == 0){
                        break;
                  }
                  k = k%fact;
                  fact = fact / (number.size());
            }
            return ans;
      }
      public static void main(String[] args) {
            System.out.println(getPermutation(4, 17));
      }
}
