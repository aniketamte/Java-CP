
import java.util.ArrayList;

public class Leetcode1823 {

      //Brute Force Approach
      public int findTheWinner(int n, int k) {
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i=1; i<=n; i++){
                  arr.add(i);
            }

            int index = 0;
            while(arr.size() > 1){
                  int idx = (index + k - 1) % arr.size();
                  arr.remove(idx);
                  index = idx;
            }
            return arr.get(0);
      }
      public static void main(String[] args) {
            Leetcode1823 solution = new Leetcode1823();

            int n = 5; // total number of players
            int k = 2; // count to eliminate

            int winner = solution.findTheWinner(n, k);
            System.out.println("The winner is: " + winner);
      }
}
