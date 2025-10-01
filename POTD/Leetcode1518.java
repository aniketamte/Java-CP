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

      //Approach2

      public static int numWaterBottles2(int numBottles, int numExchange){
            int consumed = numBottles;
            int emptyBottle = numBottles;

            while(emptyBottle >= numExchange){
                  int extraFullBottle = emptyBottle / numExchange;
                  int remain = emptyBottle % numExchange;
                  consumed += extraFullBottle;
                  emptyBottle = remain + extraFullBottle;
            }
            return consumed;
      }
      
      public static void main(String[] args) {
           int numBottles = 9;
           int numExchange = 3;
           System.out.println(numWaterBottles(numBottles, numExchange)); 
           System.out.println(numWaterBottles2(numBottles, numExchange));
      }
}
