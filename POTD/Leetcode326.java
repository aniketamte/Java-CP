public class Leetcode326 {
      /*public static boolean isPowerOfThree(int n){
            while(n >= 3){
                  if(n%3 != 0){
                        return false;
                  } else{
                        n = n/3;
                  }
            }
            return n == 1;
      }*/

      //Recursive approach

      public static boolean isPowerOfThree(int n){
            if(n <= 0){
                  return false;
            }

            if(n == 1){
                  return true;
            }

            return n%3==0 && isPowerOfThree(n/3);
      }

      public static void main(String[] args) {
            int n = 27;
            System.out.println(isPowerOfThree(n));
      }
}
