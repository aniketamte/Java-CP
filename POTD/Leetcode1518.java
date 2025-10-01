public class Leetcode1518 {
      public static int numWaterBottles(int numBottles, int numExchange){
            int consumed = 0;
            while(numBottles >= numExchange){
                  consumed += numExchange;
                  numBottles -= numExchange;
                  numBottles += 1;
            }
            return consumed + numBottles;
      }
      
      public static void main(String[] args) {
           int numBottles = 9;
           int numExchange = 3;
           System.out.println(numWaterBottles(numBottles, numExchange)); 
      }
}
