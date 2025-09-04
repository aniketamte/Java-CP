import java.util.*;
public class IndianCoins {
      public static int Coins(Integer coins[]){
            Arrays.sort(coins, Comparator.reverseOrder());

            int countOfCoins = 0;
            int amount = 590;

            ArrayList<Integer> ans = new ArrayList<>();

            for(int i=0; i<coins.length; i++){
                  if(coins[i] <= amount){
                        while(coins[i] <= amount){
                            ans.add(coins[i]);
                            amount -= coins[i];
                            countOfCoins++;
                        }
                  }
            }
            for(int i=0; i<ans.size(); i++){
                  System.out.print(ans.get(i) + " ");
            }
            System.out.println();
            return countOfCoins;
      }
      public static void main(String[] args) {
            Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
            System.out.println(Coins(coins));
      }
}
